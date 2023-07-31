package com.jumarket.api.services

import com.jumarket.api.dto.request.ShoppingCartDTO
import com.jumarket.api.dto.response.ShoppingCartProductView
import com.jumarket.api.dto.response.ShoppingCartView
import com.jumarket.api.entities.Product
import com.jumarket.api.entities.ShoppingCart
import com.jumarket.api.repositories.ShoppingCartProductRepository
import com.jumarket.api.repositories.ShoppingCartRepository
import com.jumarket.api.services.exceptions.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ShoppingCartService (
    @Autowired private val repository: ShoppingCartRepository,
    @Autowired private val repositoryShoppingCartProduct: ShoppingCartProductRepository
){

    fun findById(id: Long) : ShoppingCartView {
        val shoppingCart: ShoppingCart = repository.findById(id).orElseThrow(){ BusinessException("Id não Existente") };
        val shoppingCartView: ShoppingCartView = ShoppingCartView();
        shoppingCartView.setPaymentMethod(shoppingCart.paymentMethod);

        //lista de produtos --
        val products :List<ShoppingCartProductView> = repositoryShoppingCartProduct.findAllByShoppingCartId(id)
            .map { it -> ShoppingCartProductView(it)}
        shoppingCartView.setProducts(products);

        //calcular preco total
        var totalPrice : Double = 0.0;
        products.forEach {it -> totalPrice += it.totalPrice};
        shoppingCartView.setTotalPrice(totalPrice);

        return shoppingCartView;
    }

    fun update(id: Long, shoppingCartDTO: ShoppingCartDTO): ShoppingCart {
        val shoppingCart :ShoppingCart = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        shoppingCart.paymentMethod = shoppingCartDTO.paymentMethod;
        return repository.save(shoppingCart);
    }

    fun insert(shoppingCart: ShoppingCart): ShoppingCart {
        if(repository.findById(shoppingCart.id).isPresent){
            throw BusinessException("Carrinho Existente!");
        } else return repository.save(shoppingCart);
    }
    fun deleteById(id: Long) {
        val shoppingCart = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        repository.delete(shoppingCart);
    }

}