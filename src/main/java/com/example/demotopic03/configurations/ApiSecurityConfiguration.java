package com.example.demotopic03.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Base64;

@Configuration
@Order(1)
@EnableWebSecurity
public class ApiSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    public ApiSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**")
                .authorizeRequests()
                .anyRequest()
//                .antMatchers(HttpMethod.POST)
                .hasAnyRole("API");

        http.httpBasic();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("API_USERNAME")
                .password(passwordEncoder.encode("API_PASSWORD"))
                .roles("API");
    }


    /*public static void main(String[] args) {

        String username = "API_USERNAME";
        String password = "API_PASSWORD";

        String basicKey = Base64.getUrlEncoder().encodeToString((username + ":" + password).getBytes());

        System.out.println(basicKey);

    }*/


}
