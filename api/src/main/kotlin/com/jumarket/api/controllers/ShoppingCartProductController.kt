package com.jumarket.api.controllers

import com.jumarket.api.dto.request.ShoppingCartProductDTO
import com.jumarket.api.entities.ShoppingCartProduct
import com.jumarket.api.services.ShoppingCartProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/shoppingcartproduct")
class ShoppingCartProductController (
    @Autowired val service: ShoppingCartProductService
){

    @PutMapping(value = ["/{id}"])
    fun update(@PathVariable id: Long, @RequestBody shoppingCartProductDTO: ShoppingCartProductDTO): ShoppingCartProduct {
        return service.update(id, shoppingCartProductDTO);
    }

    @PostMapping
    fun insert(@RequestBody shoppingCartProduct: ShoppingCartProduct): ShoppingCartProduct {
        return service.insert(shoppingCartProduct);
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Long) {
        service.deleteById(id);
    }
}