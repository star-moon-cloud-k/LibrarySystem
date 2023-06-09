package com.exclaimation.librarysystem.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {
    private final String[] PERMIT = {"/images/**", "/auth/**", "/css/**", "/user/**", "/", "book/**"};

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request ->
                        request
                                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                                .requestMatchers(PERMIT).permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/seat/**", "/user/**").hasRole("USER")
                                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/")
                        .loginProcessingUrl("/auth/login-process")
                        .usernameParameter("id")
                        .passwordParameter("pw")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(withDefaults());
        return http.build();
    }
}
