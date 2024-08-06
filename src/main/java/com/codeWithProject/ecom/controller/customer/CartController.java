package com.codeWithProject.ecom.controller.customer;

import com.codeWithProject.ecom.dto.AddProductInCartDto;
import com.codeWithProject.ecom.dto.OrderDto;
import com.codeWithProject.ecom.dto.PlaceOrderDto;
import com.codeWithProject.ecom.exceptions.ValidationException;
import com.codeWithProject.ecom.services.customer.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/coupon/{userId}/{code}")
    public   ResponseEntity<?>  applyCoupon(@PathVariable Long userId, @PathVariable String code){

        try{
            OrderDto orderDto=cartService.applyCoupon(userId,code);
            return  ResponseEntity.ok(orderDto);
        }catch(ValidationException ex){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping("/addition")
    public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){

        return  ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseProductQuantity(addProductInCartDto)) ;

    }

    @PostMapping("/deduction")
    public ResponseEntity<OrderDto> decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto){

        return  ResponseEntity.status(HttpStatus.CREATED).body(cartService.decreaseProductQuantity(addProductInCartDto)) ;

    }
    @PostMapping("/placeOrder")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto){

        return  ResponseEntity.status(HttpStatus.CREATED).body(cartService.placeOrder(placeOrderDto)) ;

    }
@GetMapping("/myOrdrrs/{userId}")
public  ResponseEntity<List<OrderDto>> getMysPlacedOrdrs(@PathVariable Long userId){
        return  ResponseEntity.ok(cartService.getMyPlaceOrders(userId));
}

}
