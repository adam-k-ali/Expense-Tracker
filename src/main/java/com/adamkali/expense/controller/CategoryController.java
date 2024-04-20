package com.adamkali.expense.controller;

import com.adamkali.expense.model.Category;
import com.adamkali.expense.respository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepository.save(category);
        return ResponseEntity.created(new URI("/api/category/" + result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category) {
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
