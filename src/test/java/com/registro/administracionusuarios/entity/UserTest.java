package com.registro.administracionusuarios.entity;

import com.registro.administracionusuarios.entity.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Test;


import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

class UserTest {

    @Test
    public void deberiaCrearUsuario(){
        //arrange
        User user = new User(1L,"Carlos","Junco",27);
        User userTwo= new UserTestDataBuilder().build();
        //act-assert
        assertEquals("both equeals", user.getName(),userTwo.getName());
        assertTrue("yeah! is that true", user.validateEqualUser(userTwo));
    }


    @Test
    public void edadCorrect(){
        //arrange
        User user= new UserTestDataBuilder().withAge(27).build();
        // act - assert
        assertEquals("La edad es igual", 27, user.getAge());
    }

}