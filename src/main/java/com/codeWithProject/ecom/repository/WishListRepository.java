package com.codeWithProject.ecom.repository;

import com.codeWithProject.ecom.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<Wishlist, Long> {



}
