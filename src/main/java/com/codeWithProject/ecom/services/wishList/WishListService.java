package com.codeWithProject.ecom.services.wishList;

import com.codeWithProject.ecom.dto.WishListDto;

import java.util.List;

public interface WishListService {

    WishListDto addProductToWishList(WishListDto wishListDto);

    List<WishListDto> getWishlistByUserId(Long userId);
}
