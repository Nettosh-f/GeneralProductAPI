package com.example.GeneralWebProject.controller;

// File: src/main/java/com/example/webapp/controller/ProductController.java


import com.example.GeneralWebProject.dto.ProductDTO;
import com.example.GeneralWebProject.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * REST controller for product-related operations.
 */
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = "Product management APIs")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Get all products.
     *
     * @return list of all products
     */
    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * Get a product by ID.
     *
     * @param id the product ID
     * @return the product with the given ID
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Returns a single product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    public ResponseEntity<ProductDTO> getProductById(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    /**
     * Search products by name.
     *
     * @param name the name to search for
     * @return list of products matching the name
     */
    @GetMapping("/search")
    @Operation(summary = "Search products by name", description = "Returns a list of products matching the search criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    public ResponseEntity<List<ProductDTO>> searchProductsByName(
            @Parameter(description = "Name to search for", required = true)
            @RequestParam String name) {
        return ResponseEntity.ok(productService.findProductsByName(name));
    }

    /**
     * Get products with price less than or equal to the provided amount.
     *
     * @param maxPrice the maximum price
     * @return list of products with price less than or equal to maxPrice
     */
    @GetMapping("/price")
    @Operation(summary = "Get products by maximum price",
            description = "Returns a list of products with price less than or equal to the provided amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    public ResponseEntity<List<ProductDTO>> getProductsByMaxPrice(
            @Parameter(description = "Maximum price", required = true)
            @RequestParam BigDecimal maxPrice) {
        return ResponseEntity.ok(productService.findProductsByMaxPrice(maxPrice));
    }

    /**
     * Get products that are in stock.
     *
     * @return list of products with quantity in stock greater than zero
     */
    @GetMapping("/in-stock")
    @Operation(summary = "Get products in stock",
            description = "Returns a list of products with quantity in stock greater than zero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    public ResponseEntity<List<ProductDTO>> getProductsInStock() {
        return ResponseEntity.ok(productService.findProductsInStock());
    }

    /**
     * Create a new product.
     *
     * @param productDTO the product to create
     * @return the created product
     */
    @PostMapping
    @Operation(summary = "Create a new product", description = "Creates a new product and returns the created product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = Object.class)))
    })
    public ResponseEntity<ProductDTO> createProduct(
            @Parameter(description = "Product to create", required = true)
            @Valid @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    /**
     * Update a product.
     *
     * @param id the product ID
     * @param productDTO the product data to update
     * @return the updated product
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Updates a product and returns the updated product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(schema = @Schema(implementation = Object.class))),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    public ResponseEntity<ProductDTO> updateProduct(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id,
            @Parameter(description = "Updated product object", required = true)
            @Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(id, productDTO));
    }

    /**
     * Delete a product.
     *
     * @param id the product ID
     * @return no content
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Deletes a product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Product not found", content = @Content)
    })
    public ResponseEntity<Void> deleteProduct(
            @Parameter(description = "Product ID", required = true)
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}