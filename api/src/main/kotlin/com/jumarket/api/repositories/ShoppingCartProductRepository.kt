package com.jumarket.api.repositories

import com.jumarket.api.entities.ShoppingCartProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShoppingCartProductRepository: JpaRepository<ShoppingCartProduct, Long>{
}