package com.codeWithProject.ecom.services.customer;

import com.codeWithProject.ecom.dto.ProductDetailsDto;
import com.codeWithProject.ecom.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> getAllProducts();


     List<ProductDto> searchProductByTitle(String title);

     ProductDetailsDto getProductDetailsById(Long productId);

}
