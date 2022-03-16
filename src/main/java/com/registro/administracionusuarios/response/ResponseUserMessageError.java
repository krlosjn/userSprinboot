package com.registro.administracionusuarios.response;

public class ResponseUserMessageError extends ResponseUserMessage{

    private String message;

    public ResponseUserMessageError(String message) {
        this.message=message;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
