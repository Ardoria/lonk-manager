package com.example.lonkmanager.service.impl;

import com.example.lonkmanager.dto.LinkDefinition;
import com.example.lonkmanager.dto.LinkListItem;
import com.example.lonkmanager.exception.BusinessException;
import com.example.lonkmanager.persistance.repository.CategoryRepository;
import com.example.lonkmanager.persistance.repository.LinkRepository;
import com.example.lonkmanager.service.ILinkService;
import com.example.lonkmanager.exception.NotFoundException;
import com.example.lonkmanager.dto.LinkItem;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.example.lonkmanager.persistance.entity.Category;
import com.example.lonkmanager.persistance.entity.Link;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LinkService implements ILinkService {
    private final LinkRepository linkRepository;
    private final CategoryRepository categoryRepository;

    public LinkService(LinkRepository linkRepository, CategoryRepository categoryRepository) {
        this.linkRepository = linkRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<LinkListItem> findAll() {
        return linkRepository.findAll()
                .stream()
                .map(p -> new LinkListItem(p.getId(),p.getDate(),p.getName(),p.getPath(),p.getCategory()))
                .toList();
    }

    @Override
    public LinkItem findOne(long id) {
        Link entity = linkRepository.findById(id).orElseThrow(() -> new NotFoundException("J'ai pas trouvé ><"));
        return new LinkItem(entity.getId(), entity.getDate(), entity.getName(), entity.getPath(), entity.getCategory());
    }

    public void delete(long id) {
        Link link = linkRepository.findById(id).orElseThrow(() -> new NotFoundException("J'ai pas trouvé ><"));
        linkRepository.delete(link);
    }

    @Override
    public List<LinkListItem> findByCategory(long id) {

        return linkRepository.findAll()
                .stream()
                .filter(l -> l.getCategory().getId().equals(id))
                .map(p -> new LinkListItem(p.getId(),p.getDate(),p.getName(),p.getPath(),p.getCategory()))
                .toList();
    }

    @Override
    public LinkItem save(LinkDefinition link, long id) {
        try {
            System.out.println(id);
            Category cat = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("J'ai pas trouvé ><"));

            Link entity;
            if(link.getId()!=null){
                entity = linkRepository.findById(link.getId()).orElseThrow(() -> new NotFoundException("J'ai pas trouvé"));
                entity.setDate(new Date());
                entity.setName(link.getName());
                entity.setPath(link.getPath());
                entity.setCategory(cat);

            } else {
                entity = new Link(null, new Date(), link.getName(),link.getPath(), cat);
            }
            entity = linkRepository.save(entity);
            return new LinkItem(entity.getId(), entity.getDate(), entity.getName(), entity.getPath(),entity.getCategory());
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void deleteMultiple(List<Long> ids) {

    }

    public List<LinkListItem> findByCategory() {

        return null;
    }

    public LinkItem save(LinkItem link) {
        Link entity;
        return null;
    }
}
