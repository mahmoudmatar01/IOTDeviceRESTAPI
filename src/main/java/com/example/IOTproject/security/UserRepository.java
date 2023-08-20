package com.example.IOTproject.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,String> {
    AppUser findByEmail(String email);
}
