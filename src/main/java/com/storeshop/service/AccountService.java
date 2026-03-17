package com.storeshop.service;

import com.storeshop.entity.AppRole;
import com.storeshop.entity.AppUser;

public interface AccountService {
    AppUser AddUser(String username, String password, String email, String ConfirmPassword);
    AppRole AddRole (String roleName);
    void AddRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
    
    // Méthodes utilitaires pour initialisation
    AppRole ensureRoleExists(String roleName);
    AppUser ensureUserExists(String username, String password, String email);
}
