package com.example.ems;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.csrf()
                .disable()
                .formLogin()
                .loginPage("login")
                .permitAll();
        return http.build();
    }
}
