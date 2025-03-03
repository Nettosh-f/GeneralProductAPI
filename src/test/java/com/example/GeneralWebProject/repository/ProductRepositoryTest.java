package com.example.GeneralWebProject.repository;

// File: src/test/java/com/example/webapp/repository/ProductRepositoryTest.java


import com.example.GeneralWebProject.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ProductRepository.
 */
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameContainingIgnoreCase_ShouldReturnMatchingProducts() {
        // Create test products
        Product product1 = new Product();
        product1.setName("Laptop");
        product1.setDescription("High-performance laptop");
        product1.setPrice(new BigDecimal("1299.99"));
        product1.setQuantityInStock(50);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("Gaming Laptop");
        product2.setDescription("High-performance gaming laptop");
        product2.setPrice(new BigDecimal("1899.99"));
        product2.setQuantityInStock(30);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("Smartphone");
        product3.setDescription("Latest smartphone model");
        product3.setPrice(new BigDecimal("899.99"));
        product3.setQuantityInStock(100);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        // Save products to DB
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.flush();

        // Test findByNameContainingIgnoreCase with lowercase search
        List<Product> laptops = productRepository.findByNameContainingIgnoreCase("laptop");

        assertEquals(2, laptops.size());
        assertTrue(laptops.stream().anyMatch(p -> p.getName().equals("Laptop")));
        assertTrue(laptops.stream().anyMatch(p -> p.getName().equals("Gaming Laptop")));

        // Test findByNameContainingIgnoreCase with mixed case search
        List<Product> laptopsUppercase = productRepository.findByNameContainingIgnoreCase("LaPtOp");

        assertEquals(2, laptopsUppercase.size());
    }

    @Test
    void findByPriceLessThanEqual_ShouldReturnProductsWithPriceLessThanOrEqual() {
        // Create test products
        Product product1 = new Product();
        product1.setName("Budget Phone");
        product1.setDescription("Affordable smartphone");
        product1.setPrice(new BigDecimal("299.99"));
        product1.setQuantityInStock(200);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("Mid-range Phone");
        product2.setDescription("Good value smartphone");
        product2.setPrice(new BigDecimal("499.99"));
        product2.setQuantityInStock(150);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("Premium Phone");
        product3.setDescription("High-end smartphone");
        product3.setPrice(new BigDecimal("999.99"));
        product3.setQuantityInStock(75);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        // Save products to DB
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.flush();

        // Test findByPriceLessThanEqual
        List<Product> affordablePhones = productRepository.findByPriceLessThanEqual(new BigDecimal("500.00"));

        assertEquals(2, affordablePhones.size());
        assertTrue(affordablePhones.stream().anyMatch(p -> p.getName().equals("Budget Phone")));
        assertTrue(affordablePhones.stream().anyMatch(p -> p.getName().equals("Mid-range Phone")));
        assertFalse(affordablePhones.stream().anyMatch(p -> p.getName().equals("Premium Phone")));
    }

    @Test
    void findByQuantityInStockGreaterThan_ShouldReturnProductsInStock() {
        // Create test products
        Product product1 = new Product();
        product1.setName("In Stock Item");
        product1.setDescription("Item with stock");
        product1.setPrice(new BigDecimal("99.99"));
        product1.setQuantityInStock(10);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("Out of Stock Item");
        product2.setDescription("Item without stock");
        product2.setPrice(new BigDecimal("79.99"));
        product2.setQuantityInStock(0);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        // Save products to DB
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.flush();

        // Test findByQuantityInStockGreaterThan
        List<Product> inStockItems = productRepository.findByQuantityInStockGreaterThan(0);

        assertEquals(1, inStockItems.size());
        assertEquals("In Stock Item", inStockItems.get(0).getName());
    }
}