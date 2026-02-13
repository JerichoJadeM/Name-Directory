// package com.namedir.namedirectory.security;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {


//     @Bean
//     public JdbcUserDetailsManager userDetailsManager(DataSource dataSource){

//         JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

//         // read users
//         manager.setUsersByUsernameQuery(
//             "select username, password, enabled from app_users where username=?");
//         manager.setAuthoritiesByUsernameQuery(
//             "Select username, authority from authorities where username=?");


//         //write users
//         // manager.setCreateUserSql(
//         //     "INSERT INTO app_users (username, password, enabled) VALUES (?,?,?)"
//         // );

//         // manager.setCreateAuthoritySql(
//         //     "INSERT INTO authorities (username, authority) VALUES (?,?)"
//         // );

//         return manager;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

//         http.authorizeHttpRequests(configurer -> configurer
//                     .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
//                     .requestMatchers("/login", "/authenticateUser", "/register", "/register/**").permitAll()
//                     .anyRequest().authenticated())

//                     .formLogin(form -> form.loginPage("/login")
//                     .loginProcessingUrl("/authenticateUser")
//                     .defaultSuccessUrl("/persons/list", true)
//                     .permitAll())

//                     .rememberMe(remember -> remember
//                         .tokenValiditySeconds(120)
//                         .key("myKey")
//                         .rememberMeParameter("rememberMe")
//                     )

//                     .logout(logout -> logout.permitAll());

//         return http.build();
//     }

// }
