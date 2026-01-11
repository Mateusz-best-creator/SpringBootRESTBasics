package com.example.labolatory4.service;

import com.example.labolatory4.model.Category;
import com.example.labolatory4.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    final private CategoryRepository repository;

    CategoryService(CategoryRepository repo) {
        this.repository = repo;
    }

    public ArrayList<Category> getAllCategories() {
        return (ArrayList<Category>) this.repository.findAll();
    }

    public String addCategory(Category cat) {
        List<Category> categories = this.repository.findAll();
        for (Category category : categories) {
            if (category.getName().equals(cat.getName())) {
                return "Cannot add category with name: " +
                        category.getName() + ", it already exists";
            }
        }
        this.repository.save(cat);
        return "Category: " + cat.getName() + " added successfully.";
    }

    public String deleteCategory(Integer category_id) {
        if (repository.existsById(category_id)) {
            repository.deleteById(category_id);
            return "Removed category with ID: " + category_id;
        }
        return "Category with given ID: + " + category_id + " does not exist";
    }
}
