package com.codeWithProject.ecom.services.customer.review;

import com.codeWithProject.ecom.dto.OrderProductResponseDto;

public interface ReviewService {
   OrderProductResponseDto getOrderProductDetailsByOrder(Long orderId);
}
