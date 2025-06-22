package com.primedeals.product.controller;

import com.primedeals.product.entity.Product;
import com.primedeals.product.service.ProductService;
import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping("/products")
  public ResponseEntity<List<Product>> getProducts() {
    return ResponseEntity.ok(productService.getProducts());
  }

  @GetMapping("/products/{slug}")
  public ResponseEntity<Product> getProductBySlug(@PathVariable String slug) {
    return ResponseEntity.ok(productService.getProductBySlug(slug).orElse(null));
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> getProductBySlug(@PathVariable UUID id) {
    return ResponseEntity.ok(productService.getProductById(id).orElse(null));
  }

  @PostMapping("/admin/products")
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    return ResponseEntity.ok(productService.createProduct(product));
  }
}
