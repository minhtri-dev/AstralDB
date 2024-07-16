package com.example.warptracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warptracker.model.warptrackerdb.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
