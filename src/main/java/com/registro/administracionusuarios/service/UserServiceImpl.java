package com.registro.administracionusuarios.service;

import com.registro.administracionusuarios.entity.User;
import com.registro.administracionusuarios.repository.UserRepository;
import com.registro.administracionusuarios.response.ResponseUserMessage;
import com.registro.administracionusuarios.response.ResponseUserMessageError;
import com.registro.administracionusuarios.response.ResponseUserMessageOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Cuando se utiliza la anotación @Service, no se puede usar @Bean , ya que
 * infiere dos bean.
 * **/

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public ResponseEntity<ResponseUserMessage> saveUser(User user) {

        if(userRepository.existsUserById(user.getId())){
            String message="El usuario con identificación " + user.getId() + "" +
                    "ya se encuentra registrado, no se puede insertar ";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUserMessageError(message));
        }
        User userSend= userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseUserMessageOk(user.getId(),user.getName(),user.getLastName()));
    }
    @Override
    public ResponseEntity<ResponseUserMessage> findUser(Long id) {
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseUserMessageOk(userRepository.findById(id)));
    }

    @Override
    public List<User> findAllusers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

}
