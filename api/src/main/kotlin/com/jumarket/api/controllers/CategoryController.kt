package com.jumarket.api.controllers

import com.jumarket.api.entities.Category
import com.jumarket.api.repositories.CategoryRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/category")
@Tag(name = "Category", description = "Endpoint for managing categories.")
class CategoryController (
    @Autowired val repository: CategoryRepository
){


    @GetMapping
    fun findAll() : List<Category>{
        return repository.findAll();
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): Optional<Category> {
        return repository.findById(id);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody category: Category /*dto*/){
        //service
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        repository.deleteById(id);
    }
}