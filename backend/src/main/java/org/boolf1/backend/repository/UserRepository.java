package org.boolf1.backend.repository;

import java.util.Optional;

import org.boolf1.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
