package com.example.lonkmanager.utils;

import com.example.lonkmanager.persistance.repository.CategoryRepository;
import com.example.lonkmanager.persistance.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOHelper {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LinkRepository linkRepository;


}
