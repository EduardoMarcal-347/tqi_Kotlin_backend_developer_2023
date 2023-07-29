package com.jumarket.api.services.exceptions

data class BusinessException(override val message: String?) : RuntimeException(message)