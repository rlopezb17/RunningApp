package com.runningback.controller;


import com.runningback.dto.ApiResponse;
import com.runningback.dto.UserDto;
import com.runningback.entity.User;
import com.runningback.jwt.JwtService;
import com.runningback.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200/")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final IUserService userService;
    private final JwtService jwtService;

    public UserController(AuthenticationManager authenticationManager, IUserService userService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserDto userDto) {
        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());

        userService.registerUser(newUser);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", null));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserDto userDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.generateToken(userDto.getEmail());
            userDto.setToken(token);

            return ResponseEntity.ok(new ApiResponse(true, "Login successful", Map.of("token", token)));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ApiResponse(false, "Invalid credentials", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Something went wrong", null));
        }
    }

}
