package com.storeshop.repositories;

import com.storeshop.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

  boolean existsByNom(String nom);

  Categorie findByNom(String nom);
}
