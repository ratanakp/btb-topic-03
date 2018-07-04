package com.example.demotopic03.models;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class Role implements GrantedAuthority {

    private Long id;
    private String role;


    private List<User> users;


    public Role() {
    }

    public Role(Long id, String role, List<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", users=" + users +
                '}';
    }
}
