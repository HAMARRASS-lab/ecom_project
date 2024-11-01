package com.codeWithProject.ecom.services.wishList;

import com.codeWithProject.ecom.dto.WishListDto;
import com.codeWithProject.ecom.entity.Product;
import com.codeWithProject.ecom.entity.User;
import com.codeWithProject.ecom.entity.Wishlist;
import com.codeWithProject.ecom.repository.ProductRepository;
import com.codeWithProject.ecom.repository.UserRepository;
import com.codeWithProject.ecom.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService{

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final WishListRepository wishListRepository;

    public WishListDto addProductToWishList(WishListDto wishListDto){
        Optional<Product> optionalProduct = productRepository.findById(wishListDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(wishListDto.getUserId());

        if(optionalProduct.isPresent() && optionalUser.isPresent()){
            Wishlist wishlist=new Wishlist();
            wishlist.setProduct(optionalProduct.get());
            wishlist.setUser(optionalUser.get());

            return  wishListRepository.save(wishlist).getWishlistDto();

        }
       return  null;
    }


    public List<WishListDto> getWishlistByUserId(Long userId){
          return  wishListRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
    }
}
