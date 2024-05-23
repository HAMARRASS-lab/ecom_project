package com.codeWithProject.ecom.services.cart;

import com.codeWithProject.ecom.dto.AddProductInCartDto;
import com.codeWithProject.ecom.entity.CartItems;
import com.codeWithProject.ecom.entity.Order;
import com.codeWithProject.ecom.entity.Product;
import com.codeWithProject.ecom.entity.User;
import com.codeWithProject.ecom.enums.OrderStatus;
import com.codeWithProject.ecom.repository.CartItemRepository;
import com.codeWithProject.ecom.repository.OrderRepository;
import com.codeWithProject.ecom.repository.ProductRepository;
import com.codeWithProject.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImp  implements  CartService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?>  addProductToCrt(AddProductInCartDto addProductInCartDto){
        Order activeOrder = orderRepository.findByUserIdAndOrderStatus(addProductInCartDto.getProductId(), OrderStatus.Pending);
        Optional<CartItems> optionalCartItems=cartItemRepository.findByProductIdAndOrderIdAndUserId(addProductInCartDto.getProductId(), activeOrder.getId(), addProductInCartDto.getUserId());


        if(optionalCartItems.isPresent()){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }else{
            Optional<Product> optionalProduct=productRepository.findById(addProductInCartDto.getProductId());
            Optional<User> optionalUser=userRepository.findById(addProductInCartDto.getUserId());

            if(optionalProduct.isPresent() && optionalUser.isPresent()){
                CartItems cart= new CartItems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1L);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);
                CartItems updatedCart=cartItemRepository.save(cart);

                activeOrder.setTotalAmount(activeOrder.getAmount() + cart.getPrice());
                activeOrder.setAmount(activeOrder.getAmount() + cart.getPrice());
                activeOrder.getCartItems().add(cart);
                orderRepository.save(activeOrder);
                return  ResponseEntity.status(HttpStatus.CREATED).body(cart);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");
            }
        }
    }


}
