package com.jumarket.api.dto.response

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.enums.PaymentMethod

class ShoppingCartView {
    private lateinit var products: List<ShoppingCartProductView>;
    private var totalPrice: Double = 0.0;
    private var paymentMethod: PaymentMethod = PaymentMethod.DINHEIRO;

    public fun getProducts(): List<ShoppingCartProductView>{
        return this.products;
    }
    public fun setProducts(products: List<ShoppingCartProductView>){
        this.products = products;
    }
    public fun setTotalPrice(totalPrice: Double ){
        this.totalPrice = totalPrice;
    }
    public fun getTotalPrice(): Double {
        return this.totalPrice;
    }
    public fun getPaymentMethod(): PaymentMethod {
        return this.paymentMethod;
    }
    public fun setPaymentMethod(paymentMethod: PaymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
