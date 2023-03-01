package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items_t")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer quantityItem;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;


    public OrderItem(){}

    public OrderItem(Integer quantityItem, Item item, Order order) {
        this.quantityItem = quantityItem;
        this.item = item;
        this.order = order;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Integer quantityItem) {
        this.quantityItem = quantityItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return item + ", " + "Кол-во : " + quantityItem +"шт." + ", " +  order ;
    }
}
