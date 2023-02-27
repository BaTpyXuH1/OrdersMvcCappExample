package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String itemName;          // название товара
    @Column(nullable = false)
    private Integer itemArticle;      // артикул товара

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItemSet = new HashSet<>();
//    @ManyToMany(mappedBy = "itemSet",cascade = CascadeType.ALL)
//    private Set<Order> orderSet = new HashSet<>();


    public Item(){
        id = -1;
        itemArticle = (int)(Math.random()*100000);
    }

    public Item(String itemName, Integer itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(Integer itemArticle) {
        this.itemArticle = itemArticle;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemArticle=" + itemArticle +
                '}';
    }
}
