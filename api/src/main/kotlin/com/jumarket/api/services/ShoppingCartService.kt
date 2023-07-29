package com.jumarket.api.services

import com.jumarket.api.dto.response.ShoppingCartView
import com.jumarket.api.entities.ShoppingCart
import com.jumarket.api.repositories.ShoppingCartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingCartService (
    @Autowired private val repository: ShoppingCartRepository
){

    fun findById(id: Long) : ShoppingCartView {
        val category: ShoppingCart = repository.findById(id).orElseThrow(); /* tratar erro*/
        return ShoppingCartView();
    }


}