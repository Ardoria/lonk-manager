package com.example.lonkmanager.service;

import com.example.lonkmanager.dto.CategoryDefinition;
import com.example.lonkmanager.dto.CategoryItem;
import com.example.lonkmanager.dto.CategoryListItem;

import java.util.List;

public interface ICategoryService {

    List<CategoryListItem> findAll();

    CategoryItem save(CategoryDefinition resource);

    void delete(long id);

}
