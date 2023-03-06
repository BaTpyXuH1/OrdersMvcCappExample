package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client_t")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 200)
    private String clientName;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)   // поле в таблице заказов
    public Set<Order> orderSet;
    @OneToOne(mappedBy = "client")
    private User user;


    public Client() {
    }


    public Client(String clientName,User user) {
        this.clientName = clientName;
        this.user = user;
        this.orderSet = new HashSet<>();
    }
    public Client(User user){
        this.user = user;
        this.clientName = "";
        this.orderSet = new HashSet<>();

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "( " + clientName + " )";

    }
}
