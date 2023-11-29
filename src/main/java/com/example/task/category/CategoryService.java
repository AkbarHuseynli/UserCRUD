package com.example.task.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public boolean addCategory(Category category) {
        categoryRepository.save(category);
        log.info(category.getName() + "added successfully!");
        return true;
    }

    public boolean deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
        log.info("Category deleted successfully!");
        return true;
    }
}
