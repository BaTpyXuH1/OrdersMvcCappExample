package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client_t")

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(nullable = false, length = 200)
    public String clientName;                // имя клиента
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)   // поле в таблице заказов
    public Set<Order> orderSet;

    public Client() {

    }
    public Client(Integer id,String clientName){
        this.id = id;
        this.clientName = clientName;
    }

    public Client(String clientName) {
        this.clientName = clientName;
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

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "-" + id + " - " + clientName + "-";

    }
}
