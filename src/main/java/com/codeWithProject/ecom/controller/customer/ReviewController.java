package com.codeWithProject.ecom.controller.customer;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;
import com.codeWithProject.ecom.dto.ReviewDto;
import com.codeWithProject.ecom.services.customer.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/ordered-product/{orderId}")
    public ResponseEntity<OrderProductResponseDto> getOrderedProducDetailsOrderId(@PathVariable Long orderId){
        return  ResponseEntity.ok(reviewService.getOrderProductDetailsByOrder(orderId));
    }

    @PostMapping("/review")
    public  ResponseEntity<?> giveReview(@ModelAttribute ReviewDto reviewDto) throws IOException {
         ReviewDto reviewDto1=reviewService.giveReview(reviewDto);
         if(reviewDto1==null) return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
         return  ResponseEntity.status(HttpStatus.CREATED).body(reviewDto);
    }
}
