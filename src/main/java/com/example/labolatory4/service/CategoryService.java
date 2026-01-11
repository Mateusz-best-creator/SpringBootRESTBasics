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
        this.repository.deleteAll();
    }

    public Category getById(Integer id) {
        return this.repository.findById(id).orElseThrow(
                () -> new IllegalStateException("Category with given ID: " + id + " does not exist")
        );
    }

    public ArrayList<Category> getAllCategories() {
        return (ArrayList<Category>) this.repository.findAll();
    }

    public Category addCategory(Category cat) {
        List<Category> categories = this.repository.findAll();
        for (Category category : categories) {
            if (category.getName().equals(cat.getName())) {
                throw new IllegalStateException("Cannot add category with name: " +
                        category.getName() + ", it already exists");
            }
        }
        return this.repository.save(cat);
    }

    public void deleteCategory(Integer category_id) {
        if (repository.existsById(category_id)) {
            repository.deleteById(category_id);
            return;
        }
        throw new IllegalStateException("Category with given ID: + " + category_id + " does not exist");
    }

    public Category updateCategory(Integer category_id, Category new_category) {
        Category cat = repository.findById(category_id)
                .orElseThrow(
                        () -> new IllegalStateException("Category with given ID: " +
                                category_id + " does not exist")
                );
        cat.setName(new_category.getName());
        cat.setTitle(new_category.getTitle());
        return repository.save(cat);
    }
}
