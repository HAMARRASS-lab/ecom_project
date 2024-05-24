package com.codeWithProject.ecom.controller.customer;

import com.codeWithProject.ecom.dto.AddProductInCartDto;
import com.codeWithProject.ecom.dto.OrderDto;
import com.codeWithProject.ecom.services.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CartController {


    private final CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto){

      return   cartService.addProductToCrt(addProductInCartDto) ;

    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long userId){

        OrderDto orderDto=cartService.getCartByUserId(userId);

        return  ResponseEntity.status(HttpStatus.OK).body(orderDto);

    }
}
