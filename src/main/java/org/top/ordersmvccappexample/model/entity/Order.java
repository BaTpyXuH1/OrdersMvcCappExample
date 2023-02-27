package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_t")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;

    public Order(){}

    public Order(Integer id, String description, Client client) {
        this.id = id;
        this.description = description;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + client +
                '}';
    }
}
