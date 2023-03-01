package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "basket_t")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String orderItemBasket;

    @ManyToOne
    @JoinColumn(name = "orderItem_id",nullable = false)
    public OrderItem orderItem;
    @OneToMany(mappedBy = "basket",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItemSet = new HashSet<>();

    public Basket(){}

    public Basket(String orderItemBasket, OrderItem orderItem) {
        this.orderItemBasket = orderItemBasket;
        this.orderItem = orderItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderItemBasket() {
        return orderItemBasket;
    }

    public void setOrderItemBasket(String orderItemBasket) {
        this.orderItemBasket = orderItemBasket;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    @Override
    public String toString() {
        return  orderItemBasket + "-(" +"Заказчик" + orderItem  + ')';
    }
}
