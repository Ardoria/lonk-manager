package com.example.lonkmanager.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.lonkmanager.persistance.entity.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
