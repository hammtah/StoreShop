package com.storeshop.service;

import java.util.List;

import com.storeshop.entity.Categorie;

public interface CategorieService {

    List<Categorie> getAllCategories();
    
    Categorie getCategorieById(Long id);
    
    Categorie saveCategorie(Categorie categorie);
    
    void deleteCategorie(Long id);
    
    boolean categorieExists(String nom);
}
