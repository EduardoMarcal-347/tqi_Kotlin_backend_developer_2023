package com.jumarket.api.controllers

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.entities.Product
import com.jumarket.api.repositories.ProductRepository
import com.jumarket.api.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/product")
class ProductController(
    @Autowired val service: ProductService
) {
    @GetMapping
    fun findAll() : List<ProductDTO>{
        return service.findAll();
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ProductDTO {
        return service.findById(id);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody product: ProductDTO){
        return service.update(id, product);
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        return service.deleteById(id);
    }
}