
package com.storeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storeshop.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
    boolean existsByNom(String nom);
    
    Categorie findByNom(String nom);
}