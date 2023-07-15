package com.jumarket.api.entities

import com.jumarket.api.enums.MeasureUnit
import jakarta.persistence.*

@Entity
@Table(name = "tb_product")
data class Product (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "product_name", nullable = false, length = 40)
    var name: String,

    @Column(name = "measure_unit", nullable = false)
    val measureUnit: MeasureUnit,

    @Column(name = "price", nullable = false)
    var price: Long,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category

)