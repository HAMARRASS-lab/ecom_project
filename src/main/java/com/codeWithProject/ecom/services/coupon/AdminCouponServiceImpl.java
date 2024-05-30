package com.codeWithProject.ecom.services.coupon;

import com.codeWithProject.ecom.entity.Coupon;
import com.codeWithProject.ecom.exceptions.ValidationException;
import com.codeWithProject.ecom.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements  AdminCouponService{

    private final CouponRepository couponRepository;

    public Coupon createCoupon(Coupon coupon){
        if(couponRepository.existByCode(coupon.getCode())){
             throw new ValidationException("Coupon code already exists.");
        }
        return  couponRepository.save(coupon);
    }

    public List<Coupon> getAllCoupons(){
        return   couponRepository.findAll();
    }

}
