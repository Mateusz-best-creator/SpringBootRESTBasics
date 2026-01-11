package com.example.labolatory4.dto.category;


public class CategoryCollectionReadDTO {
    public Integer id;
    public String name;
    public String title;

    public CategoryCollectionReadDTO(Integer id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public Integer getId() {return this.id;}
    public String getName() {return this.name;}
    public String getTitle() {return this.title;}
}
