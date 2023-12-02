package com.example.controller;

import com.example.model.entity.Category;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public boolean addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PostMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable Long categoryId){
        return categoryService.deleteCategory(categoryId);

    }

}
