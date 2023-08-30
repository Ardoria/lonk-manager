package com.example.lonkmanager.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category", uniqueConstraints = {@UniqueConstraint(name = "UniqueCategoryLabel", columnNames = { "name" }) })
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
