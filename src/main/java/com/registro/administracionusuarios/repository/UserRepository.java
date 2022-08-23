package com.registro.administracionusuarios.repository;

import com.registro.administracionusuarios.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //validar después esta caracteristica
    //@Query(value="SELECT id FROM User WHERE id=?",nativeQuery=true)
    //boolean userById(Long id);
    boolean existsUserById(Long id);

    @Query("SELECT u FROM  User u WHERE u.name=?1")
    User findUserByName(String name);

}
