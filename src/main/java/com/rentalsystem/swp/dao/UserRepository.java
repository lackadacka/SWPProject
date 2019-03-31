package com.rentalsystem.swp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Integer> {
    UserProfile getById(long id);
    Optional<UserProfile> findById(long id);
    Optional<UserProfile> findByEmail(String email);
    boolean existsByEmail(String email);
}