package com.registro.administracionusuarios.response;


import com.registro.administracionusuarios.entity.User;

import java.util.Optional;

public class ResponseUserMessageOk extends ResponseUserMessage {

    private Long id;
    private String name;
    private String lastName;

    public ResponseUserMessageOk(){
    }

    public ResponseUserMessageOk(Long id, String name, String lastName){
        this.id=id;
        this.name=name;
        this.lastName=lastName;
    }

    public ResponseUserMessageOk(Optional<User> optional){
        this.id=optional.get().getId();
        this.name=optional.get().getName();
        this.lastName=optional.get().getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
