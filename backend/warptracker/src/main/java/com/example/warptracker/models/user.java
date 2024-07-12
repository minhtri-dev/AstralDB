package com.example.warptracker.models;
import java.util.List;

public record user (Long user_id, String username, String email, String password, List<item> warps){}
