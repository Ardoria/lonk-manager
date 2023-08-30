package com.example.lonkmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.lonkmanager.persistance.entity.Category;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDefinition {
    private Long id;
    private String name;
    private String path;
}
