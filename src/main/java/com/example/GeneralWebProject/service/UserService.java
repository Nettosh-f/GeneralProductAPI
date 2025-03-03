

// File: src/main/java/com/example/webapp/service/UserService.java
package com.example.GeneralWebProject.service;

import com.example.GeneralWebProject.dto.UserCreateDTO;
import com.example.GeneralWebProject.dto.UserDTO;

import java.util.List;

/**
 * Service interface for user-related operations.
 */
public interface UserService {

    /**
     * Get all users.
     *
     * @return list of all users
     */
    List<UserDTO> getAllUsers();

    /**
     * Get a user by ID.
     *
     * @param id the user ID
     * @return the user
     */
    UserDTO getUserById(Long id);

    /**
     * Get a user by username.
     *
     * @param username the username
     * @return the user
     */
    UserDTO getUserByUsername(String username);

    /**
     * Create a new user.
     *
     * @param userCreateDTO the user data to create
     * @return the created user
     */
    UserDTO createUser(UserCreateDTO userCreateDTO);

    /**
     * Update a user.
     *
     * @param id the user ID
     * @param userDTO the user data to update
     * @return the updated user
     */
    UserDTO updateUser(Long id, UserDTO userDTO);

    /**
     * Delete a user.
     *
     * @param id the user ID
     */
    void deleteUser(Long id);
}