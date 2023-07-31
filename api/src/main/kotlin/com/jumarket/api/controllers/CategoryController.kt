package com.jumarket.api.controllers

import com.jumarket.api.dto.request.CategoryDTO
import com.jumarket.api.entities.Category
import com.jumarket.api.repositories.CategoryRepository
import com.jumarket.api.services.CategoryService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/category")
@Tag(name = "Category", description = "Endpoint for managing categories.")
class CategoryController (
    @Autowired val repository: CategoryRepository,
    @Autowired val service: CategoryService
){

    @GetMapping
    fun findAll() : List<CategoryDTO>{
        return service.findAll();
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): CategoryDTO {
        return service.findById(id);
    }

    @PostMapping
    fun insert(@RequestBody category: Category): Category{
        return service.insert(category);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody category: CategoryDTO){
        return service.update(id, category)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        return service.deleteById(id);
    }
}