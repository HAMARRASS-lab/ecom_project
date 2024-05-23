package com.codeWithProject.ecom.repository;

import com.codeWithProject.ecom.entity.CartItems;
import com.codeWithProject.ecom.entity.Order;
import com.codeWithProject.ecom.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemRepository  extends JpaRepository<CartItems, Long> {

Optional<CartItems> findByProductIdAndOrderIdAndUserId(Long productId, long orderId, Long userId);

}
