package com.example.demo.readinglist;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Reader {

    private String username;
    private String fullname;
    private String password;
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
