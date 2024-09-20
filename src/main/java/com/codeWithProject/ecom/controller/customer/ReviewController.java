package com.codeWithProject.ecom.controller.customer;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;
import com.codeWithProject.ecom.services.customer.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/ordered-product/{orderId}")
    public ResponseEntity<OrderProductResponseDto> getOrderedProducDetailsOrderId(@PathVariable Long orderId){
        return  ResponseEntity.ok(reviewService.getOrderProductDetailsByOrder(orderId));
    }
}
