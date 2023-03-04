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
    private String itemName;
    @Column(nullable = false)
    private Integer itemArticle;
    @Column(nullable = false)
    private Integer itemPrice;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String previewImage;
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItemSet = new HashSet<>();


    public Item(){
        id = -1;
        itemArticle = (int)(Math.random()*100000);
        itemPrice = (int)(Math.random()*10000);
    }


    public Item(String itemName, Integer itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;

    }


    public Item(String itemName, Integer itemArticle, Integer itemPrice, String previewImage) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;
        this.itemPrice = itemPrice;
        this.previewImage = previewImage;
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
    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }

    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }

    @Override
    public String toString() {
        return "(Id : " + id + ")," + itemName  + "(Артикул : " + itemArticle + ")( Цена : " + itemPrice + " $)";
    }
}
