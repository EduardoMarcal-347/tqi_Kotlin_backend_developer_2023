package com.jumarket.api.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_category")
data class Category (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "category_name", nullable = false, length = 40)
    var name: String

)