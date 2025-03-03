package com.example.GeneralWebProject.repository;

// File: src/test/java/com/example/webapp/repository/UserRepositoryTest.java


import com.example.GeneralWebProject.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UserRepository.
 */
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername_WhenUserExists_ShouldReturnUser() {
        // Create test user
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setEmail("test@example.com");
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // Save user to DB
        entityManager.persist(user);
        entityManager.flush();

        // Test findByUsername
        Optional<User> found = userRepository.findByUsername("testuser");

        assertTrue(found.isPresent());
        assertEquals("testuser", found.get().getUsername());
        assertEquals("test@example.com", found.get().getEmail());
    }

    @Test
    void findByUsername_WhenUserDoesNotExist_ShouldReturnEmpty() {
        Optional<User> found = userRepository.findByUsername("nonexistentuser");

        assertFalse(found.isPresent());
    }

    @Test
    void findByEmail_WhenUserExists_ShouldReturnUser() {
        // Create test user
        User user = new User();
        user.setUsername("emailuser");
        user.setPassword("password");
        user.setFirstName("Email");
        user.setLastName("User");
        user.setEmail("email@example.com");
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // Save user to DB
        entityManager.persist(user);
        entityManager.flush();

        // Test findByEmail
        Optional<User> found = userRepository.findByEmail("email@example.com");

        assertTrue(found.isPresent());
        assertEquals("emailuser", found.get().getUsername());
        assertEquals("email@example.com", found.get().getEmail());
    }

    @Test
    void existsByUsername_WhenUserExists_ShouldReturnTrue() {
        // Create test user
        User user = new User();
        user.setUsername("existsuser");
        user.setPassword("password");
        user.setFirstName("Exists");
        user.setLastName("User");
        user.setEmail("exists@example.com");
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // Save user to DB
        entityManager.persist(user);
        entityManager.flush();

        // Test existsByUsername
        boolean exists = userRepository.existsByUsername("existsuser");

        assertTrue(exists);
    }

    @Test
    void existsByUsername_WhenUserDoesNotExist_ShouldReturnFalse() {
        boolean exists = userRepository.existsByUsername("nonexistentuser");

        assertFalse(exists);
    }

    @Test
    void existsByEmail_WhenUserExists_ShouldReturnTrue() {
        // Create test user
        User user = new User();
        user.setUsername("emailexistsuser");
        user.setPassword("password");
        user.setFirstName("EmailExists");
        user.setLastName("User");
        user.setEmail("emailexists@example.com");
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        // Save user to DB
        entityManager.persist(user);
        entityManager.flush();

        // Test existsByEmail
        boolean exists = userRepository.existsByEmail("emailexists@example.com");

        assertTrue(exists);
    }

    @Test
    void existsByEmail_WhenUserDoesNotExist_ShouldReturnFalse() {
        boolean exists = userRepository.existsByEmail("nonexistent@example.com");

        assertFalse(exists);
    }
}
