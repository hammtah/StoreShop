# Système d'Authentification - Gestion Bibliothèque

## 📋 Résumé des Modifications

Le système utilise maintenant une **authentification basée sur une base de données** avec une page de login personnalisée.

## ✅ Fichiers Créés/Modifiés

### Nouveaux Fichiers:
1. **`entity/User.java`** - Entité JPA pour les utilisateurs
2. **`repository/UserRepository.java`** - Repository pour la gestion des utilisateurs
3. **`service/UserDetailsServiceImpl.java`** - Service d'authentification Spring Security
4. **`service/DatabaseInitializer.java`** - Initialise les utilisateurs par défaut au démarrage
5. **`controller/LoginController.java`** - Contrôleur pour la page de login
6. **`templates/login.html`** - Page de connexion personnalisée
7. **`database_schema.sql`** - Script SQL de référence

### Fichiers Modifiés:
1. **`security/ConfigSecurity.java`** - Configuration Spring Security mise à jour
2. **`templates/template1.html`** - Navbar améliorée avec nom d'utilisateur et déconnexion
3. **`templates/ListeProduit.html`** - Contrôle d'accès basé sur les rôles
4. **`pom.xml`** - Ajout de la dépendance thymeleaf-extras-springsecurity6

## 🔐 Utilisateurs par Défaut

Les utilisateurs suivants sont créés automatiquement au démarrage de l'application:

| Nom d'utilisateur | Mot de passe | Rôle  | Permissions |
|-------------------|--------------|-------|-------------|
| **admin**         | 1234         | ADMIN | Gestion complète des produits (ajout, modification, suppression) |
| **user1**         | 1234         | USER  | Consultation uniquement |
| **user2**         | 1234         | USER  | Consultation uniquement |

## 🚀 Démarrage de l'Application

1. **Assurez-vous que MySQL est en cours d'exécution**
   ```bash
   # Vérifiez que votre base de données 'gestion_bibliotheque' existe
   ```

2. **Lancez l'application Spring Boot**
   ```bash
   mvn spring-boot:run
   ```

3. **Accédez à l'application**
   - URL: http://localhost:8080
   - Vous serez automatiquement redirigé vers la page de login

## 🔑 Fonctionnalités de Sécurité

### Pages Publiques:
- `/login` - Page de connexion
- `/css/**`, `/js/**`, `/images/**`, `/uploads/**` - Ressources statiques

### Pages Nécessitant une Authentification:
- `/index` - Liste des produits (tous les utilisateurs authentifiés)
- `/` - Redirige vers `/index`

### Pages Réservées aux Administrateurs:
- `/addProduit` - Ajouter un produit
- `/editProduit` - Modifier un produit
- `/deleteProduit` - Supprimer un produit

### Navbar Dynamique:
- Affiche le nom d'utilisateur connecté
- Badge "ADMIN" pour les administrateurs
- Bouton "Ajouter Produit" visible uniquement pour les admins
- Formulaire de déconnexion sécurisé

### Liste des Produits:
- Bouton "Ajouter un produit" visible uniquement pour les admins
- Colonne "Actions" (Modifier/Supprimer) visible uniquement pour les admins
- Consultation accessible à tous les utilisateurs authentifiés

## 🗄️ Structure de la Base de Données

La table `users` sera créée automatiquement par Hibernate avec la structure suivante:

```sql
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);
```

## 📝 Notes Importantes

1. **Mot de passe encodé**: Les mots de passe sont encodés avec BCrypt
2. **Rôles**: Les rôles doivent commencer par "ROLE_" dans la base de données (exemple: "ROLE_ADMIN", "ROLE_USER")
3. **Déconnexion**: Utilisez le bouton de déconnexion dans le menu utilisateur
4. **Configuration**: La configuration de sécurité utilise form-based authentication

## 🔧 Configuration

### application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_bibliotheque
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

## 🎨 Interface Utilisateur

- **Page de Login**: Design moderne avec gradient violet
- **Navbar**: Affichage dynamique selon le rôle
- **Messages**: Alertes pour erreurs de connexion et confirmation de déconnexion

## ⚠️ Prochaines Étapes (Optionnel)

1. Ajouter une page d'inscription pour les nouveaux utilisateurs
2. Implémenter la réinitialisation de mot de passe
3. Ajouter plus de rôles (MANAGER, etc.)
4. Journaliser les connexions et actions importantes
