package com.registro.administracionusuarios.entity;

import com.registro.administracionusuarios.entity.testdatabuilder.UserTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Pruebas unitarias
 * **/
class UserTest {

    public static final String EL_NOMBRE_SE_HA_CREADO_DE_MANERA_CORRECTA = "El nombre se ha creado de manera correcta";
    public static final String LA_EDAD_ES_IGUAL = "La edad es igual";
    public static final String EL_USUARIO_SE_HA_CREADO_CORRECTAMENTE = "El usuario se ha creado correctamente";
    public static final String EL_APELLIDO_SE_CREA_CON_EXITO = "El apellido se crea con exito";

    @Test
    public void deberiaCrearUsuario() throws Exception {
        //arrange
        User user = new User(1L,"Carlos","Junco",27);
        User userTwo= new UserTestDataBuilder().build();
        //act
        boolean result = user.validateEqualUser(userTwo);
        //assert
        assertTrue(EL_USUARIO_SE_HA_CREADO_CORRECTAMENTE, result);
    }


    @Test
    public void edadCorrecta() throws Exception {
        //arrange
        User user= new UserTestDataBuilder().withAge(27).build();
        // act - assert
        assertEquals(LA_EDAD_ES_IGUAL, 27, user.getAge());
    }

    @Test
    public void nombreCorrecto() throws Exception{
        //arrange
        User userOne= new UserTestDataBuilder().withName("Carlos").build();
        User userTwo = new UserTestDataBuilder().build();
        //act
        boolean result=false;
        if(userOne.getName().equalsIgnoreCase(userTwo.getName())){
            result=true;
        }
        //assert
        assertTrue(EL_NOMBRE_SE_HA_CREADO_DE_MANERA_CORRECTA, result);
    }

    @Test
    public void apellidoCorrecto() throws Exception{
        //arrange
        User userLastName= new UserTestDataBuilder().withLastName("Junco").build();
        //act-assert
        assertEquals(EL_APELLIDO_SE_CREA_CON_EXITO,"Junco",userLastName.getLastName());
    }
}