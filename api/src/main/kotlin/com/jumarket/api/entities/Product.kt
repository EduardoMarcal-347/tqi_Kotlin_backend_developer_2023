package com.jumarket.api.entities

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
    val measureUnit: MeasureUnit,

    @Column(nullable = false)
    var price: Long,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category

)