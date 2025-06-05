package com.POS.minimercados.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.POS.minimercados.entity.User;
import com.POS.minimercados.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173/")
@RequiredArgsConstructor
public class UserController {

       private final UserRepository userRepository;

       @GetMapping
       public List<User> getAllUsers() {
              return userRepository.findAll();
       }

       @PostMapping
       public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
              return ResponseEntity.ok(userRepository.save(user));
       }

       @PutMapping("/{id}")
       public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody User user) {
              return userRepository.findById(id)
                            .map(existing -> {
                                   user.setId(existing.getId());
                                   return ResponseEntity.ok(userRepository.save(user));
                            })
                            .orElse(ResponseEntity.notFound().build());
       }

       
}
