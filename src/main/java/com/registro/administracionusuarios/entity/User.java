package com.registro.administracionusuarios.entity;


import javax.persistence.*;

@Entity
@Table(name="User")
public class User {

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

    public User(Long id, String name, String lastName, int edad) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = edad;
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
        if(this.name.equalsIgnoreCase(user.name) && this.lastName.equalsIgnoreCase(user.lastName) && this.age==user.age){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
