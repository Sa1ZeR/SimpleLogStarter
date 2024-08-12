package com.sa1zer.webapp.repo;

import com.sa1zer.webapp.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Override
    @EntityGraph(attributePaths = "orders")
    Optional<User> findById(Long id);
}
