package com.jumarket.api.entities

import com.jumarket.api.enums.PaymentMethod
import jakarta.persistence.*

@Entity
@Table(name = "tb_shopping_cart")
data class ShoppingCart(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var totalPrice: Double,

    @Column(nullable = false)
    var paymentMethod: PaymentMethod
)