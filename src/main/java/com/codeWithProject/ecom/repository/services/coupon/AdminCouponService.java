package com.codeWithProject.ecom.repository.services.coupon;

import com.codeWithProject.ecom.entity.Coupon;

import java.util.List;

public interface AdminCouponService {

    Coupon createCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
