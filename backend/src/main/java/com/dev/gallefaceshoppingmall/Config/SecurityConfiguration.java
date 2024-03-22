package com.dev.gallefaceshoppingmall.Config;


import com.dev.gallefaceshoppingmall.entity.Role;
import org.springframework.boot.autoconfigure.jms.JmsProperties.Listener.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dev.gallefaceshoppingmall.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JWTAuthenticationFilter jwtAuthenticationFilter;

    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request -> request
            .requestMatchers("/api/v1/auth/**").permitAll()
            .requestMatchers("/api/v1/admin").hasAuthority(Role.ADMIN.name())
            .requestMatchers("/api/v1/user").hasAuthority(Role.USER.name())
            .anyRequest().authenticated())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
    http.authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
    return http.build();
    }

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        SessionManagementConfigurer<HttpSecurity> manager;
        http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request -> request.requestMatchers("/api/v1/auth/**")
        .permitAll()
        .requestMatchers("/api/v1/admin").hasAuthority(Role.ADMIN.name())
        .requestMatchers("/api/v1/user").hasAuthority(Role.USER.name())
        .anyRequest().authenticated())

    .sessionManagement(management -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    .authenticationProvider(authenticationProvider()).addFilterBefore(
        jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
        );
        return http.build();
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(null);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
    throws Exception{
        return config.getAuthenticationManager();
    }

}