package com.example.warptracker.model.warptrackerdb;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "hsr_uid")
    private Long hsr_uid;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Warp> warps;

    // Default constructor
    public User() {
    }

    // Placeholder user
    public User(Long userId) {
        this.userId = userId;
    }

    // Constructor for a complete user
    public User(Long userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHsrId() {
        return hsr_uid;
    }

    public void setHsrId(Long hsr_uid) {
        this.hsr_uid = hsr_uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Warp> getWarps() {
        return warps;
    }

    public void setWarps(Set<Warp> warps) {
        this.warps = warps;
    }
}
