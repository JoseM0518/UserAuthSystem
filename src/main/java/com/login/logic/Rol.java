package com.login.logic;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rolName;
    private String description;
    @OneToMany(mappedBy = "rol")
    private List<User> userList;

    public Rol() {
    }

    public Rol(Integer id, String rolName, String description, List<User> userList) {
        this.id = id;
        this.rolName = rolName;
        this.description = description;
        this.userList = userList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolName() {
        return rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
