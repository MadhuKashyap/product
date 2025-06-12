package com.example.product.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/health")
@Tag(name = "Health Check", description = "Health check endpoints")
public class HealthController {

    @GetMapping
    @Operation(summary = "Check application health", description = "Returns a simple health check message")
    public String healthCheck() {
        return "Application is healthy!";
    }
}
