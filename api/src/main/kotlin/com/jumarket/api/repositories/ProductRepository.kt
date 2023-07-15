package com.jumarket.api.repositories

import com.jumarket.api.entities.Category
import com.jumarket.api.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {

    fun findProductsByCategoryEquals(category: Category) : Product;

    fun findProductsByNameContainsIgnoreCase(name: String): Product;

}