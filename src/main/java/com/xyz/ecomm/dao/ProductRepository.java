package com.xyz.ecomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.ecomm.pojo.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

}
