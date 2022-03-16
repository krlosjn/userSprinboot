package com.registro.administracionusuarios.service;

import com.registro.administracionusuarios.entity.User;
import com.registro.administracionusuarios.response.ResponseUserMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {
    ResponseEntity<ResponseUserMessage> saveUser(User user);
    ResponseEntity<ResponseUserMessage> findUser(Long id);
    List<User> findAllusers();
    User findUserByName(String name);
}
