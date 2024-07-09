package com.codeWithProject.ecom.services.admin.adminOrder;

import com.codeWithProject.ecom.dto.OrderDto;
import com.codeWithProject.ecom.entity.Order;
import com.codeWithProject.ecom.enums.OrderStatus;

import java.util.List;

public interface AdminOrderService {



    List<OrderDto> getAllPlaceOrers();


}
