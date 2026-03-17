package com.storeshop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.storeshop.entity.AppRole;
import com.storeshop.entity.AppUser;
import com.storeshop.repository.AppRoleRepository;
import com.storeshop.repository.AppUserRepository;
import com.storeshop.service.AccountService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
public class UserController {

    private AccountService accountService;
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", appUserRepository.findAll());
        return "admin/listeUsers";
    }

    @GetMapping("/users/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("roles", appRoleRepository.findAll());
        return "admin/ajouterUser";
    }

    @PostMapping("/users/add")
    public String addUser(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String confirmPassword,
                         @RequestParam String email,
                         @RequestParam(required = false) String[] roles) {
        try {
            accountService.AddUser(username, password, email, confirmPassword);
            
            if (roles != null) {
                for (String role : roles) {
                    accountService.AddRoleToUser(username, role);
                }
            }
            
            return "redirect:/admin/users?success=add";
        } catch (Exception e) {
            return "redirect:/admin/users/add?error=" + e.getMessage();
        }
    }

    @GetMapping("/users/edit")
    public String showEditUserForm(@RequestParam String userId, Model model) {
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        model.addAttribute("user", user);
        model.addAttribute("allRoles", appRoleRepository.findAll());
        return "admin/editUser";
    }

    @PostMapping("/users/edit")
    public String editUser(@RequestParam String userId,
                          @RequestParam String username,
                          @RequestParam String email,
                          @RequestParam(required = false) String password,
                          @RequestParam(required = false) String[] roles) {
        try {
            AppUser user = appUserRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
            
            user.setUsername(username);
            user.setEmail(email);
            
            // Mettre à jour le mot de passe si fourni
            if (password != null && !password.isEmpty()) {
                user.setPassword(password);
            }
            
            appUserRepository.save(user);
            
            // Mettre à jour les rôles
            user.getRoles().clear();
            if (roles != null) {
                for (String roleName : roles) {
                    AppRole role = appRoleRepository.findById(roleName).orElse(null);
                    if (role != null) {
                        user.getRoles().add(role);
                    }
                }
            }
            
            return "redirect:/admin/users?success=edit";
        } catch (Exception e) {
            return "redirect:/admin/users?error=" + e.getMessage();
        }
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam String userId) {
        try {
            appUserRepository.deleteById(userId);
            return "redirect:/admin/users?success=delete";
        } catch (Exception e) {
            return "redirect:/admin/users?error=" + e.getMessage();
        }
    }
}
