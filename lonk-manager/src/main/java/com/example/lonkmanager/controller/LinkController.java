package com.example.lonkmanager.controller;

import com.example.lonkmanager.dto.*;
import com.example.lonkmanager.persistance.entity.Category;
import com.example.lonkmanager.service.ICategoryService;
import com.example.lonkmanager.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @Autowired
    private ICategoryService categoryService;

    public List<CategoryListItem> getCategories() {
        return categoryService.findAll();
    }

    public void deleteCategory(@PathVariable long id) {
        categoryService.delete(id);
    }

    @PostMapping(path = "/category")
    public CategoryItem saveCategory(@RequestBody CategoryDefinition resource) {
    return null;
    }

    @GetMapping(path = "/links")
    List<LinkListItem> findAll() {
        return linkService.findAll();
    }

    @GetMapping(path = "/link/{id}")
    LinkItem findOne(@PathVariable Long id){
        return linkService.findOne(id);
    }

    @DeleteMapping(path = "/link/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    void delete(@PathVariable Long id) {
        linkService.delete(id);
    }

    @GetMapping(path = "/category/{id}/links")
    List<LinkListItem> findByCategory(@PathVariable long id) {
        return linkService.findByCategory(id);
    }



}
