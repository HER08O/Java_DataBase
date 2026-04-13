package com.example.task3.service;

import com.example.task3.model.User;
import com.example.task3.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void run(){
        createUser();
        deleteUser(2L);
        getUserById(3L);
        updateUser(1L,"Anton","qwrqy@gmail.com");
        findByEmail("qwrqy@gmail.com");
        existsByName("Anton");
        findAllByName("Demooon");
    }

    public void createUser() {
        User user1 = new User("Anton","D@gmail.com");
        User user2 = new User("Demooon","DD@gmail.com");
        User user3 = new User("Alex","DDD@gmail.com");
        User user4 = new User("Nicolay","DDDD@gmail.com");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public void deleteUser (Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(long id, String name, String email){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return user;
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }


}
