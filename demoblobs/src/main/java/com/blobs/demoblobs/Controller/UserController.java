package com.blobs.demoblobs.Controller;


import com.blobs.demoblobs.Model.User;
import com.blobs.demoblobs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
   private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public  void adduser(@RequestBody User user){
        userService.adduser(user);
    }
    @GetMapping("/get")
    public Optional<User> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

}
