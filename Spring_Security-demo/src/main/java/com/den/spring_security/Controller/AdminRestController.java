package com.den.spring_security.Controller;

import com.den.spring_security.Model.Role;
import com.den.spring_security.Model.User;
import com.den.spring_security.Service.RoleService;
import com.den.spring_security.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/admin")
public class AdminRestController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public List<User> userList(){
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public User showUser(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PostMapping()
    public void addUser(@RequestBody User user){
//        user.setRoles(roleService.getRoles(roles));
        userService.addUser(user);
    }

    @PutMapping()
    public User update(@RequestBody User user){
        userService.change(user, user.getRoles());
        return user;
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable long id) {
        userService.delete(id);
        return userService.listUsers();
    }

}
