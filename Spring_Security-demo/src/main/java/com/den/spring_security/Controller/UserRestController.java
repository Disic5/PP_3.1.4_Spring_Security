package com.den.spring_security.Controller;
import com.den.spring_security.Model.User;
import com.den.spring_security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public User getUserByUsername (Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
        return user;
    }
}