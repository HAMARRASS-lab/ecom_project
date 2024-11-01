package com.codeWithProject.ecom.services.admin.adminOrder;

import com.codeWithProject.ecom.dto.AnalytecsResponse;
import com.codeWithProject.ecom.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {



    List<OrderDto> getAllPlaceOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalytecsResponse calculateAnalytics();


}
