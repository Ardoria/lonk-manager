package com.example.lonkmanager.service.impl;

import com.example.lonkmanager.dto.CategoryListItem;
import com.example.lonkmanager.persistance.repository.CategoryRepository;
import com.example.lonkmanager.service.ICategoryService;
import com.example.lonkmanager.dto.CategoryDefinition;
import com.example.lonkmanager.dto.CategoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryListItem> findAll(){
        return categoryRepository.findAll()
                .stream()
                .map(p -> new CategoryListItem(p.getId(),p.getName()))
                .toList();
    }

    @Override
    public CategoryItem save(CategoryDefinition resource) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

}
