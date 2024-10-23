package com.codeWithProject.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnalytecsResponse {

    private Long placed;

    private Long shipped;

    private Long delivered;

    private Long currentMonthOrder;

    private Long previousMonthOrders;

    private Long currentMonthEarnings;

    private Long previousMonthEarnings;


}
