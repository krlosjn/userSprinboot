package com.registro.administracionusuarios.configuration;


import com.registro.administracionusuarios.repository.UserRepository;
import com.registro.administracionusuarios.service.UserService;
import com.registro.administracionusuarios.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    /*private UserRepository userRepository;
    public Configuration(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Bean
    public UserService userDependency(){
        return new UserServiceImpl(userRepository);
    }*/
}
