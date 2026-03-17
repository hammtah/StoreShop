package com.storeshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.storeshop.service.AccountService;

@SpringBootApplication
public class StoreShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreShopApplication.class, args);
	}

	@Bean
	CommandLineRunner CommandeLineRunnerDetails(AccountService accountService) {
		return args -> {
			// Créer les rôles uniquement s'ils n'existent pas
			accountService.ensureRoleExists("USER");
			accountService.ensureRoleExists("CLIENT");
			accountService.ensureRoleExists("ADMIN");
			
			// Créer l'utilisateur admin uniquement s'il n'existe pas
			accountService.ensureUserExists("admin", "1234", "admin@gmail.com");
			
			// Assigner le rôle ADMIN à admin (ne fait rien si déjà assigné)
			accountService.AddRoleToUser("admin", "ADMIN");
		};
	}
}
