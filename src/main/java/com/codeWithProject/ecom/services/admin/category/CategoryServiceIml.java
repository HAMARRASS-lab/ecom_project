package com.codeWithProject.ecom.services.admin.category;

import com.codeWithProject.ecom.dto.CategoryDto;
import com.codeWithProject.ecom.entity.Category;
import com.codeWithProject.ecom.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceIml implements  CategoryService{

  private  final CategoryRepository categoryRepository;

  public Category createcategory(CategoryDto categoryDto){
    Category category = new Category();
    category.setName(categoryDto.getName());
    category.setDescription(categoryDto.getDescription());
    return  categoryRepository.save(category);
  }
      public List<Category> getAllCategories(){
         return categoryRepository.findAll();
      }
}
