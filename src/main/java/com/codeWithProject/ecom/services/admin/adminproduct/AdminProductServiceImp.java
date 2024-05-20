package com.codeWithProject.ecom.services.admin.adminproduct;

import com.codeWithProject.ecom.dto.ProductDto;
import com.codeWithProject.ecom.entity.Category;
import com.codeWithProject.ecom.entity.Product;
import com.codeWithProject.ecom.repository.CategoryRepository;
import com.codeWithProject.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import  java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImp implements AdminProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductDto addProduct(ProductDto productDto){
        Product product=new Product();
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        byte[] imgBytes = product.getImg();
        product.setImg(imgBytes);
          Category category=categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

          product.setCategory((category));
          return productRepository.save(product).getDto();
    }

    public List<ProductDto> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return  products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductByName( String name){
        List<Product> products=productRepository.findAllByNameContaining(name);
        return  products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}

