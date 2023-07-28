package com.jumarket.api.dto.response

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.enums.PaymentMethod

data class ShoppingCartView(
    val products: HashMap<ProductDTO, ShoppingCartProductView>,
    val totalPrice: Double,
    val paymentMethod: PaymentMethod
)
