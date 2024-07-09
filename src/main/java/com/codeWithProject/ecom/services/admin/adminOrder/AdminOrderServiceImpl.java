package com.codeWithProject.ecom.services.admin.adminOrder;

import com.codeWithProject.ecom.dto.OrderDto;
import com.codeWithProject.ecom.entity.Order;
import com.codeWithProject.ecom.enums.OrderStatus;
import com.codeWithProject.ecom.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {


    private  final OrderRepository orderRepository;
    public List<OrderDto> getAllPlaceOrers(){

       List<Order> orderList=orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.Placed,OrderStatus.Shipped, OrderStatus.Delivered));
       return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());
    }


}
