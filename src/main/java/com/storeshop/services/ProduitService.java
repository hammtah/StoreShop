package com.storeshop.services;

import com.storeshop.entities.Produit;
import org.springframework.data.domain.Page;

public interface ProduitService {

  Page<Produit> searchProduits(String search, int page, int size);

  Page<Produit> searchProduitsPublic(String search, Long categorieId, int page, int size);

  Produit getProduitById(Long id);

  Produit saveProduit(Produit produit);

  void deleteProduit(Long id);

  boolean produitExists(Long id);
}
