package com.jumarket.api.services

import com.jumarket.api.dto.request.CategoryDTO
import com.jumarket.api.entities.Category
import com.jumarket.api.repositories.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService(
    @Autowired private val repository: CategoryRepository
) {

    fun findAll() : List<CategoryDTO> {
        val allProducts: List<Category> = repository.findAll();
        return allProducts.map {it -> CategoryDTO(it) }
    }

    fun findById(id: Long) : CategoryDTO {
        val category: Category = repository.findById(id).orElseThrow(); /* tratar erro*/
        return CategoryDTO(category);
    }

    fun update(id: Long, categoryDTO: CategoryDTO) {
        val categoryToUpdate = repository.findById(id).orElseThrow(); /* tratar erro*/
        categoryToUpdate.update(categoryDTO);
        repository.save(categoryToUpdate);
    }

    fun deleteById(id: Long) {
        val category = repository.findById(id).orElseThrow(); /* tratar erro*/
        repository.delete(category);
    }

}