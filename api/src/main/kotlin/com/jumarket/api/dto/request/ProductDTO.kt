package com.jumarket.api.dto.request

import com.jumarket.api.entities.Category
import com.jumarket.api.entities.Product
import com.jumarket.api.enums.MeasureUnit

data class ProductDTO(
    var name: String,
    val measureUnit: MeasureUnit,
    var price: Long,
    val category: Category
) {
    constructor(entity: Product) : this(
        name = entity.name,
        measureUnit = entity.measureUnit,
        price = entity.price,
        category = entity.category
    )
}
