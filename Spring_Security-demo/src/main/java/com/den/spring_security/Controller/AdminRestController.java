package com.den.spring_security.Controller;

import com.den.spring_security.Model.User;
import com.den.spring_security.Service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/admin")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
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
    public List<User> addUser(@RequestBody User user){
        userService.add(user, user.getRoles());
        return userService.listUsers();
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