package org.javadevelopment.repository;

import org.javadevelopment.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserRepository, UUID> {
    Optional<User> findByEmail(String email);
}
