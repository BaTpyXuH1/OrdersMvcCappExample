package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;


// таблица пользователя
@Entity
@Table(name="user_t")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;


    public User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Client client){
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
