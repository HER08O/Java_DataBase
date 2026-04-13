package com.example.task3.repository;
import com.example.task3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByEmail(String email);
    boolean existsByName(String name);
    List<User> findAllByName (String name);
}
