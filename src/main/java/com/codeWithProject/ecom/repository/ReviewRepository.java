package com.codeWithProject.ecom.repository;

import com.codeWithProject.ecom.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository  extends JpaRepository<Review,Long> {
}
