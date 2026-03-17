package com.storeshop.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class AppUser {
    @Id
    private String userId;
    
    @Column(unique = true)
    private String username;

    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AppRole> roles;
}
