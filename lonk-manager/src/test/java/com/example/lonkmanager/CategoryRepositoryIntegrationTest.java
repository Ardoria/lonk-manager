package com.example.lonkmanager;

import com.example.lonkmanager.persistance.entity.Category;
import com.example.lonkmanager.persistance.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Test
//    public void givenSetOfCategories_whenFindAll_thenReturnAllCategories() {
//        String[] labels = new String[] {"Cat1", "Cat2", "Cat3"};
//        Arrays.asList(labels).forEach(l -> entityManager.persist(new Category(null, l)));
//        entityManager.flush;
//
//        List<Category> categories = categoryRepository.findAll();
//
//        assertThat(categories.hasSize(3)).extracting(Category::getName).containsOnly(labels);
//    }

//    @Test
//    public void givenSetOfCategories_whenSavingDuplicateLabel_thenThrowsException() {
//        String[] labels = new String[] {"Cat1", "Cat2", "Cat3"};
//        Arrays.asList(labels).forEach(l -> entityManager.persist(new Category(null, l)));
//        entityManager.flush;
//
//        assertThatThrownBy(() -> categoryRepository.save(new Category(null, "Cat2")))
//        .isInstanceOf(DataIntegrityViolationException.class)
//        .hasMessageContaining("UNIQUECATEGORYLABEL");
//    }
}
