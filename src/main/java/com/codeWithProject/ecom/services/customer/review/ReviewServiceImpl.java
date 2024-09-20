package com.codeWithProject.ecom.services.customer.review;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;
import com.codeWithProject.ecom.dto.ProductDto;
import com.codeWithProject.ecom.entity.CartItems;
import com.codeWithProject.ecom.entity.Order;
import com.codeWithProject.ecom.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl  implements  ReviewService{

    private final OrderRepository orderRepository;

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

}
