package com.registro.administracionusuarios.dominio.entity;


import javax.persistence.*;

import static com.registro.administracionusuarios.dominio.dominioutils.ValidationUser.validaEdad;
import static com.registro.administracionusuarios.dominio.dominioutils.ValidationUser.validarArgumentosObligatorios;

/**
 * @Table: Se usa cuando el nombre de la tabla es diferente a la entidad en la clase Java
 * **/
@Entity
@Table(name="User")
public class User {

    public static final String EL_NOMBRE_NO_PUEDE_ESTAR_VACIO = "EL nombre no puede estar vacío";
    public static final String EL_APELLIDO_NO_PUEDE_ESTAR_VACIO = "El apellido no puede estar vacio";
    public static final String LA_EDAD_NO_PUEDE_IR_VACÍA = "La edad no puede ir vacía";


    /**
     * @Auhtor: Carlos Junco
     * @Column se usa cuando el atributo tiene un nombre diferente a la columna de la tabla
     * **/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", nullable = false)
    private Long id;

    @Column(name="name", length=20, nullable = false)
    private String name;

    @Column(name="last_name",  length=30, nullable = false)
    private String lastName;

    @Column(name="age",  nullable=false)
    private int age;

    public User() {
    }

    public User(Long id, String name, String lastName, int age) throws Exception {
        validarArgumentosObligatorios(name, EL_NOMBRE_NO_PUEDE_ESTAR_VACIO);
        validarArgumentosObligatorios(lastName, EL_APELLIDO_NO_PUEDE_ESTAR_VACIO);
        validaEdad(age, LA_EDAD_NO_PUEDE_IR_VACÍA);
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(Long id){
        this.id=id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean validateEqualUser(User user){
        if(this.name.equalsIgnoreCase(user.name) && this.lastName.equalsIgnoreCase(user.lastName) && this.age==user.getAge()){
            return true;
        }
        return false;
    }
}
