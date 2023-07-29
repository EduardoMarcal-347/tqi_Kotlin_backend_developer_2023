package com.jumarket.api.services

import com.jumarket.api.dto.request.ProductDTO
import com.jumarket.api.entities.Product
import com.jumarket.api.repositories.ProductRepository
import com.jumarket.api.services.exceptions.BusinessException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class

ProductService(
    @Autowired private val repository: ProductRepository
){

    fun findAll() : List<ProductDTO> {
        val allProducts: List<Product> = repository.findAll();
        return allProducts.map {it -> ProductDTO(it)}
    }

    fun findById(id: Long) : ProductDTO {
        val product: Product = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        return ProductDTO(product);
    }

    fun insert(product: Product): Product {
        if(repository.findById(product.id).isPresent){
            throw BusinessException("Produto Existente!");
        } else return repository.save(product);
    }

    fun update(id: Long, productDTO: ProductDTO) {
        val productToUpdate = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        productToUpdate.update(productDTO);
        repository.save(productToUpdate);
    }

    fun deleteById(id: Long) {
        val product = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        repository.delete(product);
    }

}