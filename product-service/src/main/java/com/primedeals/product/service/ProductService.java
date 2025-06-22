package com.primedeals.product.service;

import com.primedeals.product.entity.Product;
import com.primedeals.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public List<Product> getProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductBySlug(String slug) {
    return productRepository.findBySlug(slug);
  }

  public Optional<Product> getProductById(UUID id) {
    return productRepository.findById(id);
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }
}
