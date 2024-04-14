package com.emuntiy.rest.webservice.controllers;

import com.emuntiy.rest.webservice.pojo.user.User;
import com.emuntiy.rest.webservice.pojo.user.UserDaoService;
import com.emuntiy.rest.webservice.pojo.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

//import static org.springframework.hateoas.server.core.WebHandler.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

//    @GetMapping("/users/{id}")
//    public User retriveUser (@PathVariable int id) {
//        return userService.findOne(id);
//    }


    @GetMapping("/users/{id}")
    public EntityModel<User> retriveHeteoasUser (@PathVariable int id) {
        User user = userService.findOne(id);
        if(user == null) {
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entryModelUser = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilderLink = linkTo(methodOn(this.getClass()).getAllUser());
        entryModelUser.add(webMvcLinkBuilderLink.withRel("all-users"));
        return entryModelUser;
       // return userService.findOne(id);
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
