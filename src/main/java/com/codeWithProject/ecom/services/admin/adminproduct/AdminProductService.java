package com.codeWithProject.ecom.services.admin.adminproduct;

import com.codeWithProject.ecom.dto.ProductDto;

import java.util.List;

public interface AdminProductService {
    public ProductDto addProduct(ProductDto productDto);
    public List<ProductDto> getAllProducts();

    List<ProductDto> getAllProductByName( String name);
}
