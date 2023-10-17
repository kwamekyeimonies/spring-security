package com.teacodesecurity.teacodesecurity.repository;

import com.teacodesecurity.teacodesecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
