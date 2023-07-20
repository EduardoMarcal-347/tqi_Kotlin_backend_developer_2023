package com.jumarket.api.controllers

import com.jumarket.api.entities.ShoppingCart
import com.jumarket.api.repositories.ShoppingCartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/shoppingcart")
class ShoppingCartController (
    @Autowired val repository: ShoppingCartRepository
) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): Optional<ShoppingCart> {
        return repository.findById(id);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody shoppingCart: ShoppingCart /*dto*/){
        //service
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        repository.deleteById(id);
    }

}