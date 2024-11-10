package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)  // Desactiva CSRF para permitir peticiones HTTP
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // Permite acceso a la consola H2
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(requests -> requests
                    // Rutas públicas
                .requestMatchers("/h2/**").permitAll()
                .requestMatchers("/api/admin/agregar").permitAll()
                .requestMatchers("/api/veterinario/agregar").permitAll()
                .requestMatchers("/api/cliente/agregar").permitAll()

                // Rutas de ADMIN
                .requestMatchers("/api/admin/**").hasAuthority("ADMIN")
                
                // Rutas compartidas entre ADMIN y VET
                .requestMatchers("/api/veterinario/**").hasAnyAuthority("ADMIN", "VET")
                
                // Rutas compartidas entre ADMIN y CLIENTE
                .requestMatchers("/api/cliente/**").hasAnyAuthority("ADMIN", "CLIENTE", "VET")
                .requestMatchers("/api/mascota/**").hasAnyAuthority("ADMIN", "CLIENTE", "VET")
                
                // Rutas exclusivas de ADMIN
                .requestMatchers("/api/medicamento/**").hasAuthority("ADMIN")
                
                .anyRequest().permitAll()
            ).exceptionHandling( exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));

            http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    /* Define la configuración de CORS de la API REST */
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.setAllowedHeaders(Arrays.asList(
            HttpHeaders.AUTHORIZATION,
            HttpHeaders.CONTENT_TYPE,
            HttpHeaders.ACCEPT  
        ));
        config.setAllowedMethods(Arrays.asList(
            HttpMethod.GET.name(),
            HttpMethod.POST.name(),
            HttpMethod.PUT.name(),
            HttpMethod.DELETE.name()
        ));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Permite autenticar a los usuarios con usuario y contraseña
     * Al autenticar devuelve un objeto Authentication que posteriormente se puede usar a traves de SecurityContextHolder
     * para obtener el usuario autenticado
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}