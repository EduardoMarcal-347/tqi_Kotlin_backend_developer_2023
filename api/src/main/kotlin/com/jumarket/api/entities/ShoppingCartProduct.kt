package com.jumarket.api.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_shopping_cart_product")
data class ShoppingCartProduct (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val shoppingCartId: Long,

    @Column
    val productId: Long,

    @Column
    val productName: String,

    @Column
    val amount: Int,

    @Column
    val totalPrice: Long
)