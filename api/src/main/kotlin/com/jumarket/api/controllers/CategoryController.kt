package com.jumarket.api.controllers

import com.jumarket.api.entities.Category
import com.jumarket.api.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

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