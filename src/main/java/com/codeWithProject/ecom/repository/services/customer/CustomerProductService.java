package com.codeWithProject.ecom.repository.services.customer;

import com.codeWithProject.ecom.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {
    public List<ProductDto> getAllProducts();
    public List<ProductDto> searchProductByTitle( String title);
}
