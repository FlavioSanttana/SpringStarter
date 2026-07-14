package org.studyeasy.SpringStarter.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.studyeasy.SpringStarter.util.constants.Privillages;
import org.studyeasy.SpringStarter.util.constants.Roles;

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
    A annotation @Bean tem um objetivo muito claro: dizer ao Spring Framework que ele deve 
    gerenciar a instância de um objeto retornado por um método. Em termos mais simples, quando 
    você anota um método com @Bean, você está assumindo manualmente o controle da criação de 
    um objeto e entregando esse objeto pronto para o container de Inversão de Controle (IoC) do Spring. 
    A partir desse momento, esse objeto torna-se um "Bean" e pode ser injetado (@Autowired) em qualquer 
    outra parte do seu código.
    */
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
            .requestMatchers("/profile/**").authenticated()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/editor/**").hasAnyRole("ADMIN", "EDITOR")
            .requestMatchers("/admin/**").hasAuthority(Privillages.ACCESS_ADMIN_PANEL.getPrivillage())
            .anyRequest()
            .authenticated()
        ) 
    
        // All others require authentication
    
        // Enable form login
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
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll()
        )
    
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