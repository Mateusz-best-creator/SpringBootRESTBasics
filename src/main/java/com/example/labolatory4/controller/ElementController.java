package com.example.labolatory4.controller;

import com.example.labolatory4.model.Element;
import com.example.labolatory4.service.ElementService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ElementController {

    private final ElementService elementService;

    public ElementController(ElementService ser) {
        this.elementService = ser;
    }

    @GetMapping("api/elements")
    public ArrayList<Element> getElements() {
        return this.elementService.getAllElements();
    }

    @PostMapping("api/categories/{category_id}/elements")
    public Element addElement(@PathVariable Integer category_id,
                             @RequestBody Element element) {
        return elementService.addElement(category_id, element);
    }

    @PutMapping("api/elements/{id}")
    public Element updateElement(@PathVariable Integer id,
                                @RequestBody Element element) {
        return elementService.updateElement(id, element);
    }

    @DeleteMapping("api/elements/{id}")
    public void deleteElement(@PathVariable Integer id) {
        elementService.deleteElement(id);
    }

}
