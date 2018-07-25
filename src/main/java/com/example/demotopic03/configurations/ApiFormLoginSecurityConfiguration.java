package com.example.demotopic03.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
public class ApiFormLoginSecurityConfiguration {

    private PasswordEncoder passwordEncoder;

    public ApiFormLoginSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        // ensure the passwords are encoded properly
        User.UserBuilder users = User.builder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("user").password(passwordEncoder.encode("user")).roles("USER").build());
        manager.createUser(users.username("user").password(passwordEncoder.encode("user")).roles("API").build());
        manager.createUser(users.username("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build());

        return manager;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/api/**")
                    .authorizeRequests()
                    .anyRequest().hasRole("API")
                    .and()

                    .httpBasic();

            http.csrf().disable();


            http
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        }
    }

    @Configuration
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        private AuthenticationSuccessHandler successHandler;

        private AuthenticationEntryPoint authenticationEntryPoint;

        private AccessDeniedHandler accessDeniedHandler;

        private AuthenticationFailureHandler authenticationFailureHandler;


        public FormLoginWebSecurityConfigurerAdapter(AuthenticationSuccessHandler successHandler,
                                                     AuthenticationEntryPoint authenticationEntryPoint) {
            this.successHandler = successHandler;
            this.authenticationEntryPoint = authenticationEntryPoint;
//            this.accessDeniedHandler = accessDeniedHandler;
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            /*http
                    .authorizeRequests()
                    .anyRequest().authenticated();*/


            http.authorizeRequests()
                    .antMatchers("/swagger-ui/**").hasRole("ADMIN");
            //.and()
            //.formLogin();

            /*http.authorizeRequests()
                    .antMatchers("/swagger-ui/**").authenticated();*/

//            http.authorizeRequests()
//                    .antMatchers("/**").access("hasRole('ROLE_USER')")
//                    .and()
            http
                    .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login/submit")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
//                    .defaultSuccessUrl("/swagger-ui")
                    .successHandler(successHandler)
                    .failureUrl("/login?error=true")
                    .failureHandler(authenticationFailureHandler);


            http.logout()
                    .logoutSuccessUrl("/login")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));


            http
                    .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler)
//                    .accessDeniedPage("/login?accessdenied=true")
                    .authenticationEntryPoint(authenticationEntryPoint);

            http
                    .sessionManagement()
                    .invalidSessionUrl("/login");

        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resources/**");
        }
    }



//    String apiKey = Base64.getUrlEncoder().encodeToString("API_HANCHEYECORESORT_USERNAME:API_HANCHEYECORESORT_PASSWORD".getBytes());


}
