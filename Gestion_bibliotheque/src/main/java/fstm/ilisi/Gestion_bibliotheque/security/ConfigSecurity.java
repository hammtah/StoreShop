package fstm.ilisi.Gestion_bibliotheque.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        return httpSecurity
                .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/index", true)
                    .permitAll()
                )
                .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login", "/css/**", "/js/**", "/images/**", "/uploads/**").permitAll()
                    .requestMatchers("/deleteProduit/**", "/addProduit", "/editProduit/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
                .build();
    }

}
