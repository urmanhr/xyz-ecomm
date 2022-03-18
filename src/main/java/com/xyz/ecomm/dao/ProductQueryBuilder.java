package com.xyz.ecomm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.xyz.ecomm.exception.ProductNotfoundException;
import com.xyz.ecomm.pojo.Brand;
import com.xyz.ecomm.pojo.Product;
import com.xyz.ecomm.pojo.Supplier;

@Service
public class ProductQueryBuilder {

	@Autowired
	private EntityManager entityManager;

	public List<Product> getAllProducts(int page, int offset) {
		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		cq.select(products);
		TypedQuery<Product> q = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset);
		List<Product> result = q.getResultList();
		if (CollectionUtils.isEmpty(result)) {
			throw new ProductNotfoundException();
		}
		return result;
	}

	public List<Product> getAllProductsByBrand(String brand, int page, int offset) {
		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		Join<Product, Brand> productBrandJoin = products.join("brand", JoinType.INNER);
		cq.select(products).where(cb.equal(productBrandJoin.get("name"), brand));
		List<Product> result = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset)
				.getResultList();

		return result;
	}

	public List<Product> getAllProductsByPrice(float price, int page, int offset) {
		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		cq.select(products).where(cb.equal(products.get("price"), price));
		List<Product> result = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset)
				.getResultList();

		return result;
	}

	public List<Product> getAllProductsByColor(String color, int page, int offset) {

		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		cq.select(products).where(cb.equal(products.get("color"), color));
		List<Product> result = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset)
				.getResultList();

		return result;
	}

	public List<Product> getAllProductsBySize(String size, int page, int offset) {
		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		cq.select(products).where(cb.equal(products.get("size"), size));
		List<Product> result = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset)
				.getResultList();

		return result;

	}

	public List<Product> getAllProductsBySku(String sku, int page, int offset) {
		int firstResult = (page - 1) * offset;
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Product> products = cq.from(Product.class);
		cq.select(products).where(cb.equal(products.get("sku"), sku));
		List<Product> result = entityManager.createQuery(cq).setFirstResult(firstResult).setMaxResults(offset)
				.getResultList();

		return result;
	}

	public long getCountOfProductsBySupplier(String supplier) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Product> products = cq.from(Product.class);
		Join<Product, Supplier> productSupplierJoin = products.join("supplier", JoinType.INNER);
		cq.select(cb.count(products.get("productId"))).where(cb.equal(productSupplierJoin.get("name"), supplier));
		return entityManager.createQuery(cq).getResultList().get(0);
	}

}
