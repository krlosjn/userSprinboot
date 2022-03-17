package com.registro.administracionusuarios.entity.testdatabuilder;

import com.registro.administracionusuarios.entity.User;

public class UserTestDataBuilder {
    private Long id;
    private String name;
    private String lastName;
    private int age;


    public UserTestDataBuilder(){
        this.id=1L;
        this.name="Carlos";
        this.lastName="Junco";
        this.age=27;
    }

    public UserTestDataBuilder withId(Long id){
        this.id=id;
        return this;
    }

    public UserTestDataBuilder withName(String name){
        this.name=name;
        return this;
    }

    public UserTestDataBuilder withLastName(String lastName){
        this.lastName=lastName;
        return this;
    }

    public UserTestDataBuilder withAge(int age){
        this.age=age;
        return this;
    }

    public User build() throws Exception{
        return new User(id,name,lastName,age);
    }
}
