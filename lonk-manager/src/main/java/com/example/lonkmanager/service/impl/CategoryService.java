package com.example.lonkmanager.service.impl;

import com.example.lonkmanager.dto.CategoryListItem;
import com.example.lonkmanager.dto.LinkItem;
import com.example.lonkmanager.exception.BusinessException;
import com.example.lonkmanager.exception.NotFoundException;
import com.example.lonkmanager.persistance.entity.Category;
import com.example.lonkmanager.persistance.entity.Link;
import com.example.lonkmanager.persistance.repository.CategoryRepository;
import com.example.lonkmanager.service.ICategoryService;
import com.example.lonkmanager.dto.CategoryDefinition;
import com.example.lonkmanager.dto.CategoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public CategoryItem save(CategoryDefinition cat) {

        try {
            Category entity;
            if(cat.getId()!=null){
                entity = categoryRepository.findById(cat.getId()).orElseThrow(() -> new NotFoundException("J'ai pas trouvé"));
                entity.setName(cat.getName());
            } else {
                entity = new Category(null, cat.getName());
            }
            entity = categoryRepository.save(entity);
            return new CategoryItem(entity.getId(), entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {

    }

}
