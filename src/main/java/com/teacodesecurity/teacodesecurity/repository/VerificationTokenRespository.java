package com.teacodesecurity.teacodesecurity.repository;

import com.teacodesecurity.teacodesecurity.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRespository extends JpaRepository<VerificationToken,Long> {
}
