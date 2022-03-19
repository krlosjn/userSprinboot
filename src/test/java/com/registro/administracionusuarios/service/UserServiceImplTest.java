package com.registro.administracionusuarios.service;

import com.registro.administracionusuarios.entity.User;
import com.registro.administracionusuarios.entity.testdatabuilder.UserTestDataBuilder;
import com.registro.administracionusuarios.response.ResponseMessageDeleteUser;
import com.registro.administracionusuarios.response.ResponseUserMessage;
import com.registro.administracionusuarios.response.ResponseUserMessageOk;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * pruebas de integración
 * **/
class UserServiceImplTest {

    @Test
    public void saveUser() throws Exception {
        //arrange
        User user = new UserTestDataBuilder().build();
        UserService userService=Mockito.mock(UserService.class);
        Mockito.when(userService.saveUser(user))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(new ResponseUserMessageOk(user.getId(),user.getName(),user.getLastName(),user.getAge())));
        //act
        ResponseEntity<ResponseUserMessage> userTest= userService.saveUser(user);
        //assert
        assertEquals(201,userTest.getStatusCodeValue());
        Mockito.verify(userService, Mockito.times(1)).saveUser(user);
    }

    @Test
    public void findUserId() throws Exception {
        //arrange
        User userFind= new UserTestDataBuilder().build();
        UserService userService=Mockito.mock(UserService.class);
        Mockito.when(userService.findUser(userFind.getId())).
                thenReturn(ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseUserMessageOk(Optional.of(userFind))));
        //act
        ResponseEntity<ResponseUserMessage> user= userService.findUser(userFind.getId());
        //assert
        assertEquals(200, user.getStatusCodeValue());
    }

    @Test
    public void deleteUser() throws Exception{
        //arrange
        User userDelete= new UserTestDataBuilder().build();
        UserService userService=Mockito.mock(UserService.class);
        Mockito.when(userService.deleteUser(userDelete.getId()))
                .thenReturn(ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body(new ResponseMessageDeleteUser(userDelete.getId())));
        //act
        ResponseEntity<ResponseUserMessage> user = userService.deleteUser(userDelete.getId());
        //assert
        assertEquals(204, user.getStatusCodeValue());
        Mockito.verify(userService,Mockito.times(1)).deleteUser(userDelete.getId());
    }

    @Test
    public void updateUser() throws Exception{
        //arrange
        User userUpdate= new UserTestDataBuilder().build();
        Long idUser=1L;
        UserService userService=Mockito.mock(UserService.class);
        Mockito.when(userService.updateUser(userUpdate,idUser))
                .thenReturn(ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseUserMessageOk(userUpdate.getId(), userUpdate.getName(), userUpdate.getLastName(),userUpdate.getAge())));
        //act
        ResponseEntity<ResponseUserMessage> updateUser= userService.updateUser(userUpdate,idUser);
        //arrange
        assertEquals(200, updateUser.getStatusCodeValue());
    }

    @Test
    public void findUserByName() throws Exception{
        //arrange
        User userName= new UserTestDataBuilder().build();
        String nameToFind="Carlos";
        UserService userService=Mockito.mock(UserService.class);
        Mockito.when(userService.findUserByName(nameToFind)).thenReturn(userName);
        //act
        User userFind = userService.findUserByName(nameToFind);
        //assert
        assertEquals("Carlos",userFind.getName());
    }


}