package com.example.labolatory4.dto.category;

public class CategoryReadDTO {

    private Integer id;
    private String name;
    private String title;

    public CategoryReadDTO() {

    }

    public CategoryReadDTO(Integer id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public Integer getId() {return this.id;}
    public String getName() {return this.name;}
    public String getTitle() {return this.title;}
    public void setId(Integer id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setTitle(String title) {this.title=title;}

}
