package com.jumarket.api.controllers

import com.jumarket.api.dto.request.ShoppingCartDTO
import com.jumarket.api.dto.response.ShoppingCartView
import com.jumarket.api.entities.Product
import com.jumarket.api.entities.ShoppingCart
import com.jumarket.api.repositories.ShoppingCartRepository
import com.jumarket.api.services.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/v1/shoppingcart")
class ShoppingCartController (
    @Autowired val repository: ShoppingCartRepository,
    @Autowired val service: ShoppingCartService
) {
    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Long): ShoppingCartView {
        return service.findById(id);
    }

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody shoppingCartDTO: ShoppingCartDTO): ShoppingCart{
        return service.update(id,shoppingCartDTO);
    }

    @PostMapping
    fun insert(@RequestBody shoppingCart: ShoppingCart): ShoppingCart {
        return service.insert(shoppingCart);
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        service.deleteById(id);
    }

}