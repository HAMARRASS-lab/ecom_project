package com.codeWithProject.ecom.repository;

import com.codeWithProject.ecom.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouponRepository  extends JpaRepository<Coupon,Long> {

    boolean existByCode(String code);
}
