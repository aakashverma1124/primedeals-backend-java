package com.primedeals.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductServiceApplication {

  public static void main(String[] args) {
    var ctx = SpringApplication.run(ProductServiceApplication.class, args);
    Environment env = ctx.getEnvironment();
    System.out.println(">>> Active profiles: " + String.join(", ", env.getActiveProfiles()));
  }
}
