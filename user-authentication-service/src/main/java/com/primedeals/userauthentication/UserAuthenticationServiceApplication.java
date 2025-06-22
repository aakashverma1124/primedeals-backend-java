package com.primedeals.userauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
public class UserAuthenticationServiceApplication {

  public static void main(String[] args) {
    var ctx = SpringApplication.run(UserAuthenticationServiceApplication.class, args);
    Environment env = ctx.getEnvironment();
    System.out.println(">>> Active profiles: " + String.join(", ", env.getActiveProfiles()));
  }
}
