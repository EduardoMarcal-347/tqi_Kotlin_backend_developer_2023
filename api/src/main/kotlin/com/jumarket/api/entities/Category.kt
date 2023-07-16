package com.jumarket.api.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_category")
data class Category (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var name: String

)