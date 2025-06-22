package com.primedeals.userauthentication.controller;

import com.primedeals.userauthentication.dto.AuthRequest;
import com.primedeals.userauthentication.dto.AuthResponse;
import com.primedeals.userauthentication.dto.RegisterRequest;
import com.primedeals.userauthentication.entity.User;
import com.primedeals.userauthentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/auth/signup")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest registerRequest) {
    return ResponseEntity.ok(authenticationService.register(registerRequest));
  }

  @PostMapping("/auth/login")
  public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
    return ResponseEntity.ok(authenticationService.authenticate(authRequest));
  }

  @PostMapping("/admin/register")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<User> registerAdmin(@RequestBody RegisterRequest registerRequest) {
    return ResponseEntity.ok(authenticationService.registerAdmin(registerRequest));
  }
}
