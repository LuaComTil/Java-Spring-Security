package com.lfr.springsecurity.repository;

import com.lfr.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface userRepository extends JpaRepository<User, UUID> {
}
