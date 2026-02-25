-- Script SQL pour créer la table des utilisateurs
-- Base de données: gestion_bibliotheque

-- Créer la table users si elle n'existe pas
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

-- Insérer des utilisateurs par défaut (les mots de passe sont encodés avec BCrypt pour "1234")
-- Note: Ces utilisateurs seront créés automatiquement par l'application au démarrage
-- Ce script est fourni à titre de référence uniquement

-- Structure de la table des produits (pour référence)
CREATE TABLE IF NOT EXISTS produit (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255),
    categorie VARCHAR(255),
    image_url VARCHAR(500),
    description TEXT,
    prix DOUBLE,
    stock INT
);

-- Exemples de données pour tester
-- INSERT INTO produit (nom, categorie, description, prix, stock) VALUES
-- ('Livre Java', 'Informatique', 'Guide complet de Java', 45.99, 10),
-- ('Livre Python', 'Informatique', 'Programmation Python avancée', 39.99, 15),
-- ('Livre Spring Boot', 'Informatique', 'Développement avec Spring Boot', 52.50, 8);
