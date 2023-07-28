package com.jumarket.api.dto.request

import com.jumarket.api.entities.Category

data class CategoryDTO (
    var name: String
) {
    constructor(entity: Category): this(
        name = entity.name
    )
}