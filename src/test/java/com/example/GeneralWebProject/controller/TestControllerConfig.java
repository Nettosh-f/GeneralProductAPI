package com.example.GeneralWebProject.controller;



import com.example.GeneralWebProject.service.ProductService;
import com.example.GeneralWebProject.service.UserService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Test configuration for controller tests.
 * Provides mocked service beans for controller tests.
 */
@TestConfiguration
public class TestControllerConfig {

    @Bean
    @Primary
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    @Primary
    public ProductService productService() {
        return Mockito.mock(ProductService.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}