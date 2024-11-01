package com.codeWithProject.ecom.services.customer.review;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;
import com.codeWithProject.ecom.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {

   OrderProductResponseDto getOrderProductDetailsByOrder(Long orderId);

   ReviewDto giveReview(ReviewDto reviewDto) throws IOException;

}
