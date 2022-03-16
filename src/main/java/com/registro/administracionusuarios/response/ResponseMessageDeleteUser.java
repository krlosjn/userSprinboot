package com.registro.administracionusuarios.response;

public class ResponseMessageDeleteUser extends ResponseUserMessage{

    private Long id;
    private String message;

    public ResponseMessageDeleteUser(Long id) {
        this.id = id;
        this.message="El usuario con id " + this.id + " ha sido eliminado";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
