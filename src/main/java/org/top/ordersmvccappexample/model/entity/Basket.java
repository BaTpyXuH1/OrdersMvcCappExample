package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;




@Entity
@Table(name = "basket_t")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String orderItemBasket;

    public Basket(){}

    public Basket(String orderItemBasket) {
        this.orderItemBasket = orderItemBasket;
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



    @Override
    public String toString() {
        return  orderItemBasket + "-(" +"Заказчик" ;
    }
}
