package com.example.product.rest;

import com.example.product.model.data.ProductData;
import com.example.product.model.form.ProductForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.product.dto.ProductDto;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Management", description = "APIs for managing products")
public class ProductController {

    @Autowired
    private ProductDto dto;

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieves a list of all products")
    public List<ProductData> getAllProducts() {
        return dto.getAllProduct();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieves a product by its ID")
    public ProductData getProductById(
            @Parameter(description = "Product ID", required = true)
            @PathVariable String id) {
        return dto.getProductById(id);
    }

    @PostMapping
    @Operation(summary = "Create new product", description = "Creates a new product")
    public void createProduct(
            @Parameter(description = "Product details", required = true)
            @RequestBody ProductForm form) {
         dto.addProduct(form);
    }
}
