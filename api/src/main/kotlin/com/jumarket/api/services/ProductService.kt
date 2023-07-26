package com.jumarket.api.services

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.entities.Product
import com.jumarket.api.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(
    @Autowired private val repository: ProductRepository
){

    fun findAll() : List<ProductDTO> {
        val allProducts: List<Product> = repository.findAll();
        return allProducts.map {it -> ProductDTO(it)}
    }

    fun findById(id: Long) : ProductDTO {
        val product: Product = repository.findById(id).orElseThrow(); /* tratar erro*/
        return ProductDTO(product);
    }

    fun update(id: Long, productDTO: ProductDTO) {
        val productToUpdate = repository.findById(id).orElseThrow(); /* tratar erro*/
        productToUpdate.update(productDTO);
        repository.save(productToUpdate);
    }

    fun deleteById(id: Long) {
        val product = repository.findById(id).orElseThrow(); /* tratar erro*/
        repository.delete(product);
    }

}