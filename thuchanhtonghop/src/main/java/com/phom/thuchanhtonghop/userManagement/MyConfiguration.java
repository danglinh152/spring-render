//package com.phom.thuchanhtonghop.userManagement;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//public class MyConfiguration {
//
//
////    @Bean
////    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////        UserDetails user1 = User.withUsername("manager").password("{noop}1111").roles("manager").build();
////        UserDetails user2 = User.withUsername("user").password("{noop}2222").roles("user").build();
////        UserDetails user3 = User.withUsername("admin").password("{noop}admin").roles("admin").build();
////        return new InMemoryUserDetailsManager(user1, user2, user3);
////    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                configurer -> configurer.requestMatchers(HttpMethod.GET, "/students").hasAnyRole("ADMIN", "MANAGER", "USER")
//                        .requestMatchers(HttpMethod.GET, "/students/**").hasAnyRole("ADMIN", "MANAGER", "USER")
//                        .requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN")
//        );
//
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf -> csrf.disable());
//        return http.build();
//    }
//
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance();
////    }
//
//}
