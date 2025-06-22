package com.primedeals.userauthentication.service;

import com.primedeals.userauthentication.dto.AuthRequest;
import com.primedeals.userauthentication.dto.AuthResponse;
import com.primedeals.userauthentication.dto.RegisterRequest;
import com.primedeals.userauthentication.entity.Role;
import com.primedeals.userauthentication.entity.User;
import com.primedeals.userauthentication.repository.UserRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  public AuthResponse register(RegisterRequest registerRequest) {
    User user =
        User.builder()
            .name(registerRequest.getName())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .phone(registerRequest.getPhone())
            .address(registerRequest.getAddress())
            .role(Role.USER)
            .createdAt(LocalDateTime.now())
            .build();

    userRepository.save(user);
    String jwtToken = jwtService.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }

  public AuthResponse authenticate(AuthRequest authRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

    User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();

    String jwtToken = jwtService.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }

  public User registerAdmin(RegisterRequest registerRequest) {
    User user =
        User.builder()
            .name(registerRequest.getName())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .phone(registerRequest.getPhone())
            .address(registerRequest.getAddress())
            .role(Role.ADMIN)
            .createdAt(LocalDateTime.now())
            .build();

    return userRepository.save(user);
  }
}
