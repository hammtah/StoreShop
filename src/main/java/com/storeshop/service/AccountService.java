package com.storeshop.service;

import com.storeshop.entity.User;

public interface AccountService {
    User AddUser(String username, String password, String email, String ConfirmPassword);
    User loadUserByUsername(String username);    
    User ensureUserExists(String username, String password, String email);
}
