package com.registro.administracionusuarios.dominio.service;

import com.registro.administracionusuarios.dominio.entity.User;
import com.registro.administracionusuarios.datosrepository.UserRepository;
import com.registro.administracionusuarios.aplicacion.response.ResponseMessageDeleteUser;
import com.registro.administracionusuarios.aplicacion.response.ResponseUserMessage;
import com.registro.administracionusuarios.aplicacion.response.ResponseUserMessageError;
import com.registro.administracionusuarios.aplicacion.response.ResponseUserMessageOk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    //@Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUserMessage> saveUser(User user) {
        if(userRepository.existsUserById(user.getId())){
            String message="El usuario con id " + user.getId() + "" +
                    "ya se encuentra registrado, no se puede insertar ";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUserMessageError(message));
        }
        User userSend= userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseUserMessageOk(user.getId(),user.getName(),user.getLastName(),user.getAge()));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<ResponseUserMessage> findUser(Long id) {
        if(!userRepository.existsUserById(id)){
            String message="Ha ocucurrido un error encontrando el usuario con id " + id;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUserMessageError(message));
        }
        Optional<User> userFind = userRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseUserMessageOk(userFind));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllusers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUserMessage> deleteUser(Long id) {
        if(!userRepository.existsUserById(id)){
            String message="No se puede eliminar el usuario con id " + id + "" +
                    " posiblemente el usuario ya no se encuentra en el sistema";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(new ResponseUserMessageError(message));
        }
        userRepository.delete(new User(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ResponseMessageDeleteUser(id));
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUserMessage> updateUser(User newUser, Long id) {
        if(!userRepository.existsUserById(id)){
            String message="El usuario con id " + id  +
                    " no se puede actualizar, por favor valide que el usuario si exista";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseUserMessageError(message));
        }
        User userUpdate = updatingUser(newUser,id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseUserMessageOk(userUpdate.getId(), userUpdate.getName(), userUpdate.getLastName(),userUpdate.getAge()));
    }


    public User updatingUser(User newUser, Long id){
        User userUpdate = userRepository.findById(id).map((user) -> {
            user.setName(newUser.getName());
            user.setLastName(newUser.getLastName());
            user.setAge(newUser.getAge());
            return userRepository.save(user);
        }).orElse(null);
        return userUpdate;
    }
}
