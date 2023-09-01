package com.example.lonkmanager.controller;

import com.example.lonkmanager.dto.*;
import com.example.lonkmanager.service.ICategoryService;
import com.example.lonkmanager.service.ILinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final ICategoryService categoryService;

    private final ILinkService linkService;


    @GetMapping(path = "/categories")
    List<CategoryListItem> findAll() {
        return categoryService.findAll();
    }
    public CategoryController(ICategoryService categoryService, ILinkService linkService) {
        this.categoryService = categoryService;
        this.linkService = linkService;
    }
//    @GetMapping(path = "/{id}/favorites")
//    List<LinkItem>;

    @PostMapping(path = "/category/{id}/links")
    public LinkItem save(@PathVariable long id, @RequestBody LinkDefinition link) {
        return linkService.save(link, id);
    }

    @PostMapping(path = "/category")
    public CategoryItem save(@RequestBody CategoryDefinition cat) {
        return categoryService.save(cat);
    }
}
