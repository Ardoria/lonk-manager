package com.example.lonkmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.lonkmanager.persistance.entity.Category;

import java.util.Date;

@Data
@AllArgsConstructor
public class LinkListItem {
    private Long id;
    private Date date;
    private String name;
    private String path;
    private Category category;
}
