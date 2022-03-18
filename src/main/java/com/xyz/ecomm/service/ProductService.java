package com.xyz.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.xyz.ecomm.dao.ProductQueryBuilder;
import com.xyz.ecomm.dao.ProductRepository;
import com.xyz.ecomm.exception.ProductNotfoundException;
import com.xyz.ecomm.pojo.Product;
import com.xyz.ecomm.pojo.ProductCart;

@Service
public class ProductService {

	@Autowired
	ProductQueryBuilder productQueryBuilder;

	@Autowired
	ProductRepository productRepository;

	@Cacheable(value = { "getAllProducts" })
	public List<Product> getAllProducts(int page, int count) {

		List<Product> products = productQueryBuilder.getAllProducts(page, count);

		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;

	}

	@Cacheable(value = { "getProductsByBrand" })
	public List<Product> getProductsByBrand(String brand, int page, int count) {
		List<Product> products = productQueryBuilder.getAllProductsByBrand(brand, page, count);

		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;
	}

	@Cacheable(value = { "getProductsByPrice" })
	public List<Product> getProductsByPrice(float price, int page, int count) {

		List<Product> products = productQueryBuilder.getAllProductsByPrice(price, page, count);

		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;
	}

	@Cacheable(value = { "getProductsByColor" })
	public List<Product> getProductsByColor(String color, int page, int count) {
		List<Product> products = productQueryBuilder.getAllProductsByColor(color, page, count);

		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;
	}

	@Cacheable(value = { "getProductsBySize" })
	public List<Product> getProductsBySize(String size, int page, int count) {
		List<Product> products = productQueryBuilder.getAllProductsBySize(size, page, count);

		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;
	}

	@Cacheable(value = { "getProductsBySku" })
	public List<Product> getProductsBySku(String sku, int page, int count) {

		List<Product> products = productQueryBuilder.getAllProductsBySku(sku, page, count);
		if (CollectionUtils.isEmpty(products)) {
			throw new ProductNotfoundException();
		}

		return products;
	}

	@Cacheable(value = { "getCountOfProductsBySupplier" })
	public long getCountOfProductsBySupplier(String supplier) {
		return productQueryBuilder.getCountOfProductsBySupplier(supplier);
	}

	@CacheEvict(allEntries = true, cacheNames = { "getAllProducts", "getCountOfProductsBySupplier", "getProductsBySku",
			"getProductsBySize", "getProductsByColor", "getProductsByPrice", "getProductsByBrand" })
	public void createProduct(Product product) {

		productRepository.save(product);

	}

	@CacheEvict(allEntries = true, cacheNames = { "getAllProducts", "getCountOfProductsBySupplier", "getProductsBySku",
			"getProductsBySize", "getProductsByColor", "getProductsByPrice", "getProductsByBrand" })
	public void buyProduct(ProductCart productcart) {
		//buy product code
	}

}
