package com.codeWithProject.ecom.repository;

import com.codeWithProject.ecom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
