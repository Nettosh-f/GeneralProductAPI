
// File: src/main/java/com/example/webapp/service/ProductService.java
package com.example.GeneralWebProject.service;

import com.example.GeneralWebProject.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for product-related operations.
 */
public interface ProductService {

    /**
     * Get all products.
     *
     * @return list of all products
     */
    List<ProductDTO> getAllProducts();

    /**
     * Get a product by ID.
     *
     * @param id the product ID
     * @return the product
     */
    ProductDTO getProductById(Long id);

    /**
     * Find products by name.
     *
     * @param name the name to search for
     * @return list of products matching the name criteria
     */
    List<ProductDTO> findProductsByName(String name);

    /**
     * Find products with price less than or equal to the provided amount.
     *
     * @param maxPrice the maximum price
     * @return list of products with price less than or equal to maxPrice
     */
    List<ProductDTO> findProductsByMaxPrice(BigDecimal maxPrice);

    /**
     * Find products that are in stock.
     *
     * @return list of products with quantity in stock greater than zero
     */
    List<ProductDTO> findProductsInStock();

    /**
     * Create a new product.
     *
     * @param productDTO the product data to create
     * @return the created product
     */
    ProductDTO createProduct(ProductDTO productDTO);

    /**
     * Update a product.
     *
     * @param id the product ID
     * @param productDTO the product data to update
     * @return the updated product
     */
    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    /**
     * Delete a product.
     *
     * @param id the product ID
     */
    void deleteProduct(Long id);
}