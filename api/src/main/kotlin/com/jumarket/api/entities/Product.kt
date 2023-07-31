package com.jumarket.api.entities

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.enums.MeasureUnit
import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
data class Product (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var measureUnit: MeasureUnit,

    @Column(nullable = false)
    var price: Long,

    @ManyToOne
    var category: Category

){
    fun update(productDTO: ProductDTO) {
        this.name = productDTO.name;
        this.measureUnit = productDTO.measureUnit;
        this.price = productDTO.price;
        this.category = productDTO.category
    }
}