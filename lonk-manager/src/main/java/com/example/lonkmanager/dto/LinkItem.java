package com.example.lonkmanager.dto;

import com.example.lonkmanager.persistance.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkItem {
    private Long id;
    private Date date;
    private String name;
    private String path;
    private Category category;

}
