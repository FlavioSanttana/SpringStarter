package org.studyeasy.SpringStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Configuration
public class WebSecurityConfig{
        
    private static final String [] WHITELIST = {
        "/",
        "login",
        "/register",
        "/db-console/**",
        "/images/**",
        "/css/**",
        "/fonts/**",
        "/js/**"
        
    };

/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Authorize requests
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(WHITELIST).permitAll() // Public endpoints
                .anyRequest().authenticated()           // All others require authentication
            )
            // Enable form login
            .formLogin(form -> form
                .loginPage("/login")       // Custom login page
                .permitAll()
            )
            // Enable logout
            .logout(logout -> logout
                .permitAll()
            )
            // CSRF protection enabled by default
            .csrf(csrf -> csrf.disable()); // Disable only if needed (e.g., for APIs)

        return http.build();
    }
*/

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(WHITELIST)
            .permitAll() // Public endpoints
            .anyRequest()
            .authenticated()
        ) // All others require authentication
        
        // CSRF protection enabled by default
        .csrf(csrf -> csrf.disable());
        
        http
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin()
            )
        );

        return http.build();
    }
    
}
