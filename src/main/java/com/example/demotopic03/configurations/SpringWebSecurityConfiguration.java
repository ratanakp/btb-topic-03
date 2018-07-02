package com.example.demotopic03.configurations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationSuccessHandler successHandler;


    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin_pumin")
                .password("{noop}admin").roles("ADMIN", "DBA", "USER")
                .and()
                .withUser("dba").password("{noop}dba").roles("DBA", "USER");

        auth.inMemoryAuthentication().withUser("user").password("{noop}user")
                .roles("USER");
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.csrf().disable();


        http.formLogin()
                .loginProcessingUrl("/login/submit")
                .usernameParameter("username_btb")
                .passwordParameter("password_btb")
                .successHandler(successHandler)
                .loginPage("/login");


        http.authorizeRequests().antMatchers("/admin/**")
                .hasAnyRole("ADMIN");

        http.authorizeRequests().antMatchers("/dba/**")
                .hasAnyRole("DBA");

        http.authorizeRequests().antMatchers("/user/**")
                .hasAnyRole("USER");


        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));


        http.exceptionHandling()
                .accessDeniedPage("/accessdenied")
                .authenticationEntryPoint(authenticationEntryPoint);


        //When session time out redirect to /book
        http.sessionManagement()
                .invalidSessionUrl("/book");

    }

}
