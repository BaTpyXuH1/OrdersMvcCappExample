package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "city_t")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String cityTitle;
    @ManyToOne
    @JoinColumn(name = "orderItem_id",nullable = false)
    public OrderItem orderItem;

    public City(){}

    public City(String cityTitle, OrderItem orderItem) {
        this.cityTitle = cityTitle;
        this.orderItem = orderItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityTitle() {
        return cityTitle;
    }

    public void setCityTitle(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityTitle='" + cityTitle + '\'' +
                ", orderItem=" + orderItem +
                '}';
    }
}
