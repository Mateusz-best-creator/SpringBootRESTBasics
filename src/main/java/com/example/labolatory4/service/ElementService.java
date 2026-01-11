package com.example.labolatory4.service;

import com.example.labolatory4.model.Category;
import com.example.labolatory4.model.Element;
import com.example.labolatory4.repository.CategoryRepository;
import com.example.labolatory4.repository.ElementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class ElementService {

    final private ElementRepository elementRepository;
    final private CategoryRepository categoryRepository;

    ElementService(ElementRepository repo_e, CategoryRepository repo_c) {
        this.elementRepository = repo_e;
        this.categoryRepository = repo_c;
    }

    public ArrayList<Element> getAllElements() {
        return (ArrayList<Element>) this.elementRepository.findAll();
    }

    public String addElement(Integer categoryId, Element element) {
        Category target_category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new IllegalStateException("given ID: " + categoryId + " does not exist")
                );
        System.out.println("Category: " + target_category);
        element.setCategory(target_category);
        elementRepository.save(element);
        return "Element successfully added to category: " + target_category;
    }
}
