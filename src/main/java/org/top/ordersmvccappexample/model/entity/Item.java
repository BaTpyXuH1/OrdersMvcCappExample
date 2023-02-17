package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;

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


    public Item(){
        id = -1;
        itemArticle = -1;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemArticle=" + itemArticle +
                '}';
    }
}
