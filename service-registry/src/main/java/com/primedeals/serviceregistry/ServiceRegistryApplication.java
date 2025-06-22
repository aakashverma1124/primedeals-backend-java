package com.primedeals.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

  public static void main(String[] args) {
    var ctx = SpringApplication.run(ServiceRegistryApplication.class, args);
    Environment env = ctx.getEnvironment();
    System.out.println(">>> Active profiles: " + String.join(", ", env.getActiveProfiles()));
  }
}
