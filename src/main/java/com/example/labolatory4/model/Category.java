package com.example.labolatory4.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name="Categories")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="title")
    private String title;
    @Column(name="password")
    private String password;

    @OneToMany(
            mappedBy = "category",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Element> elements = new ArrayList<>();

    public Category() {

    }

    public Category(Integer id, String name, String title, String password) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPassword() {return this.password;}

    public List<Element> getElements() { return elements; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassword(String password) {this.password = password;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title);
    }
}
