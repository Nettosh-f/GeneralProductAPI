
// File: src/main/java/com/example/webapp/repository/ProductRepository.java
package com.example.GeneralWebProject.repository;

import com.example.GeneralWebProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Product entity.
 * Provides database operations for the Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find products by name containing the given string (case insensitive).
     *
     * @param name the name substring to search for
     * @return list of products matching the name criteria
     */
    List<Product> findByNameContainingIgnoreCase(String name);

    /**
     * Find products with a price less than or equal to the given amount.
     *
     * @param price the maximum price
     * @return list of products with price less than or equal to the given amount
     */
    List<Product> findByPriceLessThanEqual(BigDecimal price);

    /**
     * Find products with quantity in stock greater than zero.
     *
     * @return list of products that are in stock
     */
    List<Product> findByQuantityInStockGreaterThan(Integer quantity);
}