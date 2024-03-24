package com.emuntiy.rest.webservice.controllers;

import com.emuntiy.rest.webservice.user.User;
import com.emuntiy.rest.webservice.user.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    private UserDaoService userService;

    public UserResourceController(UserDaoService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> getAllUser () {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getAllUser (@PathVariable int id) {
        return userService.findOne(id);
    }

    @DeleteMapping("/users/{id}")
    public void DeleteById (@PathVariable int id) {
        userService.deleteById(id);
    }
    @PostMapping("/user")
    public ResponseEntity<Object> postUser(@Valid @RequestBody User user) {
        User savedUser = (User) userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

       return ResponseEntity.created(location).build();
        //return savedUser;

    }

}
