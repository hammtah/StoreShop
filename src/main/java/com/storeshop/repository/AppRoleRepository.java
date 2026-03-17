package com.storeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storeshop.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
    AppRole  findByRoleName(String roleName);

}
