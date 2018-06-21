package com.formation.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dao.CategoryRepository;
import com.formation.entities.Category;

@RestController
@EnableEurekaClient
public class CategoryApi {

	protected Logger logger = Logger.getLogger(CategoryApi.class.getName());

	@Autowired
	private CategoryRepository categoryRepository;

	// Get All Category
	@GetMapping("/categories")
	public List<Category> findAll() {
		logger.info("Category.findAll()");

		//transformer en liste
		Iterable<Category> source = categoryRepository.findAll();
		List<Category> categories = new ArrayList<>();
		source.forEach(categories::add);

		return categories;
	}

	// Create a new Category
	@PostMapping("/categories")
	public Category createCategory(@Valid @RequestBody Category category) {
	    return categoryRepository.save(category);
	}
	
	// Get a Single Category
	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long categoryId) {
	    Category category = categoryRepository.findOne(categoryId);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(category);
	}
	
	// Update a Category
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateNote(@PathVariable(value = "id") Long categoryId, 
	                                       @Valid @RequestBody Category categoryDetails) {
	    Category category = categoryRepository.findOne(categoryId);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	    category.setName(categoryDetails.getName());

	    Category updatedNote = categoryRepository.save(category);
	    return ResponseEntity.ok(updatedNote);
	}
	
	// Delete a Category
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Category> deleteNote(@PathVariable(value = "id") Long categoryId) {
	    Category category = categoryRepository.findOne(categoryId);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }

	    categoryRepository.delete(category);
	    return ResponseEntity.ok().build();
	}
	
}
