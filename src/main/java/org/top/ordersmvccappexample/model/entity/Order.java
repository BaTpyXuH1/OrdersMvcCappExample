package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;
;

@Entity
@Table(name = "order_t")
public class Order {
//Сущность "Заказ"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 1000)
    private String description;   // описание заказа
    //заказ ссылается на клиента
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", nullable = false)
    public Client client;


    //конструктор по умолчанию
    public Order() {
    }

    //конструктор с параметрами
    public Order(String description, Client client) {

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
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + client +
                '}';
    }
}
