package com.example.labolatory4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Elements")
public class Element {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="element_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Integer price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    @JsonBackReference
    private Category category;

    public Element() {}
    public Element(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setCategory(Category cat) { this.category = cat; }
    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Integer getPrice() {
        return this.price;
    }
    public Category getCategory() { return category; }
}
