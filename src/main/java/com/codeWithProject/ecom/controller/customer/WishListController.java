package com.codeWithProject.ecom.controller.customer;


import com.codeWithProject.ecom.dto.WishListDto;
import com.codeWithProject.ecom.services.wishList.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/wishlist")
    public ResponseEntity<?> addProductToWishlist(@RequestBody WishListDto wishlistDto) {

        WishListDto postedWishlistDto = wishListService.addProductToWishList(wishlistDto);

        if (postedWishlistDto == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");

      return  ResponseEntity.status(HttpStatus.CREATED).body(postedWishlistDto);
    }

}
