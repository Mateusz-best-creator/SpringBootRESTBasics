package com.example.labolatory4.controller;

import com.example.labolatory4.model.Category;
import com.example.labolatory4.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService ser) {
        this.categoryService = ser;
    }

    @GetMapping
    public ArrayList<Category> getCategories() {
        return this.categoryService.getAllCategories();
    }

    @PostMapping
    public String addCategory(@RequestBody Category cat) {
        return this.categoryService.addCategory(cat);
    }

    @DeleteMapping("/{category_id}")
    public String removeCategory(@PathVariable Integer category_id) {
        return this.categoryService.deleteCategory(category_id);
    }
}
