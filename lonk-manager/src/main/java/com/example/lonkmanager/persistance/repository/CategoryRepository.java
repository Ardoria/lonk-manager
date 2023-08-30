package com.example.lonkmanager.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lonkmanager.persistance.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
