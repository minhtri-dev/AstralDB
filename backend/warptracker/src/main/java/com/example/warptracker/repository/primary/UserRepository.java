package com.example.warptracker.repository.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warptracker.model.primary.User;

@Repository
@Primary
public interface UserRepository extends JpaRepository<User, Integer> {
}
