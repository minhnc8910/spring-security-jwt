package com.example.service;

import com.example.domain.Role;
import com.example.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    //nen phan trang
    List<User> getUsers();
}
