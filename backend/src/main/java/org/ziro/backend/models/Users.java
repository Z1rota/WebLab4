package org.ziro.backend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@NamedQuery(
        name = "Users.findByUsername",  // Уникальное имя-ярлык для этого запроса
        query = "SELECT u FROM Users u WHERE u.login = :username" // Сам JPQL-запрос
)
public class Users {
    @Id
    private long id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
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
