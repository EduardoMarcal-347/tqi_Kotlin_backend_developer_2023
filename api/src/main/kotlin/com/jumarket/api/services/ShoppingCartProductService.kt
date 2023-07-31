package com.jumarket.api.services

import com.jumarket.api.dto.request.ShoppingCartDTO
import com.jumarket.api.dto.request.ShoppingCartProductDTO
import com.jumarket.api.entities.ShoppingCart
import com.jumarket.api.entities.ShoppingCartProduct
import com.jumarket.api.repositories.ShoppingCartProductRepository
import com.jumarket.api.services.exceptions.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingCartProductService(
    @Autowired private val repository: ShoppingCartProductRepository
) {

    fun update(id: Long, shoppingCartProductDTO: ShoppingCartProductDTO): ShoppingCartProduct {
        val shoppingCartProduct : ShoppingCartProduct = repository.findById(id).
            orElseThrow{ BusinessException("Id não Existente") };
        shoppingCartProduct.amount = shoppingCartProductDTO.amount;
        return repository.save(shoppingCartProduct);
    }

    fun insert(shoppingCartProduct: ShoppingCartProduct): ShoppingCartProduct {
        if(repository.findById(shoppingCartProduct.id).isPresent){
            throw BusinessException("Produto Existente no Carrinho!");
        } else return repository.save(shoppingCartProduct);
    }

    fun deleteById(id: Long) {
        val shoppingCart = repository.findById(id).orElseThrow{ BusinessException("Id não Existente") };
        repository.delete(shoppingCart);
    }


}