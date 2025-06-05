package com.POS.minimercados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.POS.minimercados.entity.User;
import com.POS.minimercados.repository.UserRepository;

import jakarta.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {
       private final UserRepository userRepository;

       public List<User> getAllUsers() {
              return userRepository.findAll();
       }

       public Optional<User> getUserById(Long id) {
              return userRepository.findById(id);
       }

       public User createUser(@Valid User user) {
              return userRepository.save(user);
       }

       public Optional<User> updateUser(Long id, @Valid User user) {
              return userRepository.findById(id).map(existing -> {
                     user.setId(existing.getId());
                     return userRepository.save(user);
              });
       }

       public boolean deleteUser(Long id) {
              return userRepository.findById(id).map(user -> {
                     userRepository.delete(user);
                     return true;
              }).orElse(false);
       }
}
