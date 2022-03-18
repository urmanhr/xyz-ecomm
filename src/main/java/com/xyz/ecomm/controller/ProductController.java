package com.xyz.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.ecomm.dao.BrandRepository;
import com.xyz.ecomm.dao.ProductRepository;
import com.xyz.ecomm.pojo.Product;
import com.xyz.ecomm.pojo.ProductCart;
import com.xyz.ecomm.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	ProductRepository productRepository;

	@GetMapping("/page/{page}/count/{count}")
	public List<Product> getAllProducts(@PathVariable("page") int page, @PathVariable("count") int count) {
		return productService.getAllProducts(page, count);
	}

	@GetMapping("brand/{brand}/page/{page}/count/{count}")
	public List<Product> getProductsByBrand(@PathVariable("brand") String brand, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		return productService.getProductsByBrand(brand, page, count);
	}

	@GetMapping("price/{price}/page/{page}/count/{count}")
	public List<Product> getProductsByPrice(@PathVariable("brand") float price, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		return productService.getProductsByPrice(price, page, count);
	}

	@GetMapping("color/{color}/page/{page}/count/{count}")
	public List<Product> getProductsByColor(@PathVariable("color") String color, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		return productService.getProductsByColor(color, page, count);
	}

	@GetMapping("size/{size}/page/{page}/count/{count}")
	public List<Product> getProductsBySize(@PathVariable("size") String size, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		return productService.getProductsBySize(size, page, count);
	}

	@GetMapping("sku/{sku}/page/{page}/count/{count}")
	public List<Product> getProductsBySku(@PathVariable("sku") String sku, @PathVariable("page") int page,
			@PathVariable("count") int count) {
		return productService.getProductsBySku(sku, page, count);
	}

	@GetMapping("supplier/{supplier}")
	public long getCountOfProductsBySupplier(@PathVariable("supplier") String supplier) {
		return productService.getCountOfProductsBySupplier(supplier);
	}

	@PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return product;
	}
	
	@PostMapping(path = "buy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean buyProduct(@RequestBody ProductCart productcart) {
		productService.buyProduct(productcart);
		return true;
	}

}
