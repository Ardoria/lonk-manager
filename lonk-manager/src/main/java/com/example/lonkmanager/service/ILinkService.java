package com.example.lonkmanager.service;

import com.example.lonkmanager.dto.LinkDefinition;
import com.example.lonkmanager.dto.LinkListItem;
import com.example.lonkmanager.dto.LinkItem;
import com.example.lonkmanager.persistance.entity.Category;

import java.util.List;

public interface ILinkService {
    List<LinkListItem> findAll();

    LinkItem findOne(long id);

    void delete(long id);

    List<LinkListItem> findByCategory(long id);

    LinkItem save(LinkDefinition link, long id);

    void deleteMultiple(List<Long> ids);
}
