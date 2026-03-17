package com.storeshop.services;

import com.storeshop.entities.Categorie;
import java.util.List;

public interface CategorieService {

  List<Categorie> getAllCategories();

  Categorie getCategorieById(Long id);

  Categorie saveCategorie(Categorie categorie);

  void deleteCategorie(Long id);

  boolean categorieExists(String nom);
}
