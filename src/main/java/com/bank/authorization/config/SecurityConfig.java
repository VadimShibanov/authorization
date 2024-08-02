package com.bank.authorization.config;

import com.bank.authorization.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SuccessUserHandler successUserHandler;

    private final Password password;

    private final UserServiceImpl userServiceImpl;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers(new AntPathRequestMatcher("/bank/user/**")).hasRole("USER");
                    auth.requestMatchers(new AntPathRequestMatcher("/bank/admin/**")).hasRole("ADMIN");
//                    auth.requestMatchers(new AntPathRequestMatcher("/bank/user/**")).permitAll();
//                    auth.requestMatchers(new AntPathRequestMatcher("/bank/admin/**")).permitAll();
                })
                .formLogin()
                .successHandler(successUserHandler)
                .and().build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userServiceImpl)
                .passwordEncoder(password.bCryptPasswordEncoder());
    }
}
