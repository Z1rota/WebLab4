package org.ziro.backend;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    private long id;
    private String login;
    private String password;

    public Users() {}


    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }


}
