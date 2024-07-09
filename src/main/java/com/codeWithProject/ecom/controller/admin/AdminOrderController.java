package com.codeWithProject.ecom.controller.admin;

import com.codeWithProject.ecom.dto.OrderDto;
import com.codeWithProject.ecom.services.admin.adminOrder.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping("/placeOrders")
    public ResponseEntity<List<OrderDto>> getAllPlaceOrders(){
        return ResponseEntity.ok(adminOrderService.getAllPlaceOrers());
    }
}