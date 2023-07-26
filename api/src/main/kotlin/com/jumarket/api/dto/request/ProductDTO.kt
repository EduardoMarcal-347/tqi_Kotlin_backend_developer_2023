package com.jumarket.api.dto.request

import com.jumarket.api.entities.Category
import com.jumarket.api.enums.MeasureUnit

data class ProductDTO(
    var name: String,
    val measureUnit: MeasureUnit,
    var price: Long,
    val category: Category
)
