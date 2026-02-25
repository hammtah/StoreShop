package fstm.ilisi.Gestion_bibliotheque.service;

import fstm.ilisi.Gestion_bibliotheque.entity.User;
import fstm.ilisi.Gestion_bibliotheque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Vérifier si les utilisateurs existent déjà
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("1234"));
            admin.setRole("ROLE_ADMIN");
            admin.setEnabled(true);
            userRepository.save(admin);
            System.out.println("Utilisateur admin créé");
        }

        if (userRepository.findByUsername("user1").isEmpty()) {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("1234"));
            user1.setRole("ROLE_USER");
            user1.setEnabled(true);
            userRepository.save(user1);
            System.out.println(" Utilisateur user1 créé");
        }
        
        if (userRepository.findByUsername("user2").isEmpty()) {
            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("1234"));
            user2.setRole("ROLE_USER");
            user2.setEnabled(true);
            userRepository.save(user2);
            System.out.println("✅ Utilisateur user2 créé");
        }
    }
}
