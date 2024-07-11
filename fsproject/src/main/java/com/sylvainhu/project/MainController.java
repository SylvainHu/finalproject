package com.sylvainhu.project;

import com.sylvainhu.project.dao.UserRepository;
import com.sylvainhu.project.dao.UserTypeRepository;
import com.sylvainhu.project.entity.User;
import com.sylvainhu.project.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    // Adding
    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email already exists.", e);
        }
    }

    @PostMapping("/typelist")
    void addUserType(@RequestBody UserType userType) {
        try {
            userTypeRepository.save(userType);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "User type already exists.", e);
        }
    }

    // Getting
    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @GetMapping("/typelist")
    public @ResponseBody Iterable<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    @GetMapping("/typelist/{id}")
    public Optional<UserType> getUserTypeById(@PathVariable int id) {
        return userTypeRepository.findById(id);
    }

    // Deleting
    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("/typelist/{id}")
    void deleteUserType(@PathVariable int id) {
        userTypeRepository.deleteById(id);
    }

    // Editing
    @PutMapping("/users/{id}")
    void editUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @PutMapping("/typelist/{id}")
    void editUserType(@PathVariable int id, @RequestBody UserType userType) {
        userType.setId(id);
        userTypeRepository.save(userType);
    }
}
