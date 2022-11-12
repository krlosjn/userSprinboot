package com.registro.administracionusuarios.aplicacion.controller;

import com.registro.administracionusuarios.dominio.entity.User;
import com.registro.administracionusuarios.aplicacion.response.ResponseUserMessage;
import com.registro.administracionusuarios.dominio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController {

    //@Autowired
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

    @DeleteMapping("/{id_user}")
    public ResponseEntity<ResponseUserMessage> deleteUser(@PathVariable("id_user") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/{id_user}")
    public ResponseEntity<ResponseUserMessage> updateUser(@RequestBody User user, @PathVariable("id_user") Long id){
        return userService.updateUser(user,id);
    }

}
