package com.xyz.ecomm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyz.ecomm.pojo.Brand;

@Repository("brandRepository")
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
