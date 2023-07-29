package com.jumarket.api.services

import com.jumarket.api.dto.request.CategoryDTO
import com.jumarket.api.entities.Category
import com.jumarket.api.repositories.CategoryRepository
import com.jumarket.api.services.exceptions.BusinessException
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
        val category: Category = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        return CategoryDTO(category);
    }

    fun insert(category: Category): Category {
        if(repository.findById(category.id).isPresent){
            throw BusinessException("Categoria Existente!");
        } else return repository.save(category);
    }

    fun update(id: Long, categoryDTO: CategoryDTO) {
        val categoryToUpdate = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        categoryToUpdate.update(categoryDTO);
        repository.save(categoryToUpdate);
    }

    fun deleteById(id: Long) {
        val category = repository.findById(id).orElseThrow{BusinessException("Id não Existente")};
        repository.delete(category);
    }

}