//package com.phom.thuchanhtonghop.userManagement;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class securityConfiguration {
//    private DataSource dataSource;
//
//
//    @Autowired
//    public securityConfiguration(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new JdbcUserDetailsManager(dataSource);
//    }
//}
