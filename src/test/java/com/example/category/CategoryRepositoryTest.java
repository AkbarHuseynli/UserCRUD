package com.example.category;

import com.example.model.entity.Category;
import com.example.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
//    @AfterEach
//    void tearDown() {
//        categoryRepository.deleteAll();
//
//    }

    @Test
    void findByName() {
        String name = "ENGLISH";
        Category category = Category.builder().name("ENGLISH").build();
        categoryRepository.save(category);
        Boolean exists = categoryRepository.findByName(name).isPresent();
        assertThat(exists).isTrue();
    }
}