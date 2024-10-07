package com.codeWithProject.ecom.services.customer.review;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;
import com.codeWithProject.ecom.dto.ProductDto;
import com.codeWithProject.ecom.dto.ReviewDto;
import com.codeWithProject.ecom.entity.*;
import com.codeWithProject.ecom.repository.OrderRepository;
import com.codeWithProject.ecom.repository.ProductRepository;
import com.codeWithProject.ecom.repository.ReviewRepository;
import com.codeWithProject.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl  implements  ReviewService{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;



    public OrderProductResponseDto getOrderProductDetailsByOrder(Long orderId){
        Optional<Order> optionalOrder=orderRepository.findById(orderId);
        OrderProductResponseDto orderProductResponseDto=new OrderProductResponseDto();
        if(optionalOrder.isPresent()){
          orderProductResponseDto.setOrderAmount(optionalOrder.get().getAmount());

         List<ProductDto> productDtoList = new ArrayList<>();
          for(CartItems cartItems: optionalOrder.get().getCartItems()){
            ProductDto productDto=new ProductDto();
            productDto.setId(cartItems.getProduct().getId());
            productDto.setName(cartItems.getProduct().getName());
            productDto.setPrice(cartItems.getPrice());
            productDto.setQuantity(cartItems.getQuantity());
            productDto.setByteImg(cartItems.getProduct().getImg());

            productDtoList.add(productDto);
          }
          orderProductResponseDto.setProductDtoList(productDtoList);
        }
        return  orderProductResponseDto;
    }

    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());

        Optional<User> optionalUser=userRepository.findById(reviewDto.getUserId());

         if(optionalProduct.isPresent() && optionalUser.isPresent()){
             Review review =new Review();

             review.setRating(review.getRating());
             review.setDescription(review.getDescription());
             review.setUser(optionalUser.get());
             review.setProduct(optionalProduct.get());
             review.setImg(reviewDto.getImg().getBytes());

             return  reviewRepository.save(review).getDto();
         }
         return null;
    }
}
