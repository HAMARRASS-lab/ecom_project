package com.codeWithProject.ecom.services.cart;

import com.codeWithProject.ecom.dto.AddProductInCartDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductToCrt(AddProductInCartDto addProductInCartDto);
}
