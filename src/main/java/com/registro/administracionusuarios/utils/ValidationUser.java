package com.registro.administracionusuarios.utils;

public class ValidationUser {

    public static void validarArgumentosObligatorios(Object attribute, String message) throws Exception {
        if(attribute==null){
            throw new Exception(message);
        }
    }

    public static void validaEdad(int age,String message) throws  Exception{
        if(age==0 || age>100 || age<0){
            throw new Exception(message);
        }
    }
}
