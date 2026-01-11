package com.example.labolatory4.service;

import com.example.labolatory4.model.Category;
import com.example.labolatory4.model.Element;
import com.example.labolatory4.repository.CategoryRepository;
import com.example.labolatory4.repository.ElementRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ElementService {

    final private ElementRepository elementRepository;
    final private CategoryRepository categoryRepository;

    ElementService(ElementRepository repo_e, CategoryRepository repo_c) {
        this.elementRepository = repo_e;
        this.categoryRepository = repo_c;
        this.categoryRepository.deleteAll();
        this.elementRepository.deleteAll();
    }

    public ArrayList<Element> getAllElements() {
        return (ArrayList<Element>) this.elementRepository.findAll();
    }

    public Element addElement(Integer categoryId, Element element) {
        Category target_category = categoryRepository.findById(categoryId)
                .orElseThrow(
                        () -> new IllegalStateException("given ID: " + categoryId + " does not exist")
                );
        element.setCategory(target_category);
        return elementRepository.save(element);
    }

    public Element updateElement(Integer elementId, Element newElement) {
        Element element = elementRepository.findById(elementId).orElseThrow(
                () -> new IllegalStateException(
                        "element with such ID: " + elementId + " does not exist."
                )
        );
        element.setName(newElement.getName());
        element.setPrice(newElement.getPrice());
        return elementRepository.save(element);
    }

    public void deleteElement(Integer elementId) {
        if (!elementRepository.existsById(elementId)) {
            throw new IllegalStateException("Element with given ID: " + elementId + " does not exist.");
        }
        elementRepository.deleteById(elementId);
    }
}
