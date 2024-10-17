package com.codeWithProject.ecom.dto;

import com.codeWithProject.ecom.entity.Product;
import com.codeWithProject.ecom.entity.User;
import lombok.Data;

@Data
public class WishListDto {


    private Long userId;

    private Long productId;

    private Long id;

    private  String productName;

    private String productDescription;

    private byte[] returnImg;

    private Long price;

}
