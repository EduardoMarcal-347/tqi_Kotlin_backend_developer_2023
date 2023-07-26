package com.jumarket.api.controllers

import com.jumarket.api.entities.Product
import com.jumarket.api.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/product")
class ProductController(
    @Autowired val repository: ProductRepository
) {
    @GetMapping
    fun findAll() : List<Product>{
        return repository.findAll();
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): Optional<Product> {
        return repository.findById(id);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody product: Product /*dto*/){
        //service
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        repository.deleteById(id);
    }
}