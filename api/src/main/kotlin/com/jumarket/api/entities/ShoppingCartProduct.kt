package com.jumarket.api.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_shopping_cart_product")
data class ShoppingCartProduct (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    val shoppingCartId: Long,

    @Column(nullable = false)
    val productId: Long,

    @Column(nullable = false)
    val productName: String,

    @Column(nullable = false)
    val amount: Int,

    @Column(nullable = false)
    val totalPrice: Long
)