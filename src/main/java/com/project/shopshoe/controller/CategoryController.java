package com.project.shopshoe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopshoe.dtos.CategoryDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/categories")
//@Validated
public class CategoryController {
	
	@GetMapping("")
	public ResponseEntity<String> getAllCategories(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit
			) {

		return ResponseEntity.ok(String.format("Get All Categories, page = %d, limit = %d", page, limit));
	}
	
	// Nếu tham số truyền vào là 1 object thì sao ? => Data transfer Object = Request Object
	@PostMapping("/insert")
	public ResponseEntity<?> insertCategory(
			@Valid @RequestBody CategoryDto categoryDto,BindingResult result
			) {
		if (result.hasErrors()) {
			List<String> errorMessage = result.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage).toList();
			return ResponseEntity.badRequest().body(errorMessage);
		}
		return ResponseEntity.ok("insert category" + categoryDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable Long id) {

		return ResponseEntity.ok("Hello cac ban");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id) {

		return ResponseEntity.ok("Hello cac ban");
	}
}
