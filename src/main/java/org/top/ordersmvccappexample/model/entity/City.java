package org.top.ordersmvccappexample.model.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "city_t")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String cityTitle;


    public City(){}

    public City(String cityTitle) {
        this.cityTitle = cityTitle;

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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityTitle='" + cityTitle +
                ", orderItem=" +
                '}';
    }
}
