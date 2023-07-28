package com.jumarket.api.dto.request

data class ShoppingCartProductDTO(
    var product: ProductDTO,
    var amount: Int,
)