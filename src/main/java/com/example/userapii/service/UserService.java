package com.example.userapii.service;

import com.example.userapii.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>(List.of(
        new User(1L, "Mario Rossi", "mario.rossi@example.com"),
        new User(2L, "Luca Bianchi", "luca.bianchi@example.com"),
        new User(3L, "Giulia Verdi", "giulia.verdi@example.com")
    ));

    public List<User> getAllUsers() { //get -> /users
        return users;
    }

    public Optional<User> getUserById(Long id) { //get -> /users/id
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<User> findUsersByName(String name) { //get -> /users/
        return users.stream()
                    .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                    .toList();
    }

    public User addUser(User newUser) {
        users.add(newUser);
        return newUser;
    }
}