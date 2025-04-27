package com.minhtri.astraldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhtri.astraldb.model.warptrackerdb.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByHsrUid(Long hsr_uid);

    User findByUsername(String username);

    User findByEmail(String email);
}
