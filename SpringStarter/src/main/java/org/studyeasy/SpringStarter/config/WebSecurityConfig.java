package org.studyeasy.SpringStarter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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


    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(WHITELIST)
            .permitAll() // Public endpoints
            .anyRequest()
            .authenticated()
            // Enable form login
              
        ) // All others require authentication
        .formLogin((form) -> form
            .loginPage("/login") // Custom login page
            .loginProcessingUrl("/login")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/",true)
            .failureUrl("/login?error")
            .permitAll()
        )
        // Enable logout
        .logout(logout -> logout
            .logoutSuccessUrl("/logout?sucess")
            .permitAll()
        )
        

        // CSRF protection enabled by default
        .csrf(csrf -> csrf.disable());
        
        http
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions
                .sameOrigin()
            )
        )
        .httpBasic(); // Enables HTTP Basic with default settings

        return http.build();
    }
    
}
