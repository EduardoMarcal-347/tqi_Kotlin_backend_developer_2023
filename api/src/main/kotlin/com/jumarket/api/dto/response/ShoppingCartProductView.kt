package com.jumarket.api.dto.response

import com.jumarket.api.dto.request.ProductDTO

data class ShoppingCartProductView(
    var product: ProductDTO,
    var amount: Int,
    var totalPrice: Long
)