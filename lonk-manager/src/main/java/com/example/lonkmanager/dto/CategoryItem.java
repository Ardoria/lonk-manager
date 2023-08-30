package com.example.lonkmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Quand on fait un trucItem, il faut qu'il corresponde à l'entité.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryItem {
    private long id;
    private String name;
}
