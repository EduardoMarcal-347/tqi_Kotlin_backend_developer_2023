package com.jumarket.api.dto.response

import com.jumarket.api.entities.ShoppingCartProduct

data class ShoppingCartProductView(
    var productName: String,
    var amount: Int,
    var productPrice: Double,
){
    constructor(entity: ShoppingCartProduct): this(
        productName = entity.productName,
        amount = entity.amount,
        productPrice = entity.price,
    )

    var totalPrice: Double = this.amount * this.productPrice;

}