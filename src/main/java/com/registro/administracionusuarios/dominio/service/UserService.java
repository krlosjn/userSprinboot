package com.registro.administracionusuarios.dominio.service;

import com.registro.administracionusuarios.dominio.entity.User;
import com.registro.administracionusuarios.aplicacion.response.ResponseUserMessage;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<ResponseUserMessage> saveUser(User user);
    ResponseEntity<ResponseUserMessage> findUser(Long id);
    List<User> findAllusers();
    User findUserByName(String name);
    ResponseEntity<ResponseUserMessage> deleteUser(Long id);
    ResponseEntity<ResponseUserMessage> updateUser(User newUser, Long id);

}
