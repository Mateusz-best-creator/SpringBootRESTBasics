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
    public Category addCategory(@RequestBody Category cat) {
        return this.categoryService.addCategory(cat);
    }

    @DeleteMapping("/{category_id}")
    public void deleteCategory(@PathVariable Integer category_id) {
        this.categoryService.deleteCategory(category_id);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Integer id,
                                 @RequestBody Category category) {
        return this.categoryService.updateCategory(id, category);
    }
}
