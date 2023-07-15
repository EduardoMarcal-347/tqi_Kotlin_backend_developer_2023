package com.jumarket.api.repositories

import com.jumarket.api.entities.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShoppinCartRepository: JpaRepository<ShoppingCart, Long> {
}