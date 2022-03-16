package com.registro.administracionusuarios.controller;

import com.registro.administracionusuarios.entity.User;
import com.registro.administracionusuarios.response.ResponseUserMessage;
import com.registro.administracionusuarios.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/users")
@RestController
public class UserController {

    private UserService userService;

    public  UserController (UserService userService){
        this.userService=userService;
    }

    @PostMapping("")
    public ResponseEntity<ResponseUserMessage> sendUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<ResponseUserMessage> getUser(@PathVariable("id_user") Long id){
        return userService.findUser(id);
    }

    @GetMapping("")
    public List<User> findAllusers(){
        return userService.findAllusers();
    }

    @GetMapping("/name/{name}")
    public User findUserByName(@PathVariable("name") String name){
        return userService.findUserByName(name);
    }


}
