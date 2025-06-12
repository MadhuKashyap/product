package com.example.product.rest;

import com.example.product.dto.InventoryDto;
import com.example.product.model.data.InventoryData;
import com.example.product.model.data.ProductData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryDto dto;
    @GetMapping
    @Operation(summary = "Get product qty by ID", description = "Retrieves list of products and their quantity")
    public List<InventoryData> getInventory(List<String> products) throws Exception {
        return dto.getInventoryById(products);
    }
}
