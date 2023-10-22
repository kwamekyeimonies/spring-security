package com.teacodesecurity.teacodesecurity.repository;

import com.teacodesecurity.teacodesecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRespitory extends JpaRepository<Role, UUID> {
    Optional<Role>findByAuthority(String authority);
}
