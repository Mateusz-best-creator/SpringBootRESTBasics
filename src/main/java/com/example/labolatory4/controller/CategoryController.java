package com.example.labolatory4.controller;

import com.example.labolatory4.dto.category.CategoryCollectionReadDTO;
import com.example.labolatory4.dto.category.CategoryCreateUpdateDTO;
import com.example.labolatory4.dto.category.CategoryReadDTO;
import com.example.labolatory4.model.Category;
import com.example.labolatory4.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService ser) {
        this.categoryService = ser;
    }

    @GetMapping
    public List<CategoryCollectionReadDTO> getCategories() {
        return this.categoryService.getAllCategories()
                .stream()
                .map(
                        c -> new CategoryCollectionReadDTO(
                                c.getId(), c.getName(), c.getTitle()
                        )
                )
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryReadDTO addCategory(@RequestBody Category cat) {
        Category saved = this.categoryService.addCategory(cat);
        return new CategoryReadDTO(saved.getId(), saved.getName(), saved.getTitle());
    }

    @DeleteMapping("/{category_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer category_id) {
        this.categoryService.deleteCategory(category_id);
    }

    @PutMapping("/{id}")
    public CategoryReadDTO updateCategory(@PathVariable Integer id,
                                          @RequestBody CategoryCreateUpdateDTO dto) {
        Category cat = categoryService.getById(id);
        cat.setName(dto.getName());
        cat.setTitle(dto.getTitle());
        Category saved = this.categoryService.updateCategory(id, cat);
        return new CategoryReadDTO(saved.getId(), saved.getName(), saved.getTitle());
    }
}
