package com.example.camunda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Order(10)
public class StartProcessApiSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ms-credit").password(passwordEncoder().encode("password")).roles("task-worker").and()
                .withUser("ms-fraud").password(passwordEncoder().encode("password")).roles("task-worker-bpmn-error").and()
                .withUser("ms-contract").password(passwordEncoder().encode("password")).roles("task-worker").and()
                .withUser("ms-application-scanner").password(passwordEncoder().encode("password")).roles("workflow-starter");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .antMatcher("/engine-rest/process-definition/key/{}/start")
                .authorizeRequests().anyRequest().hasRole("workflow-starter")
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic(); // this is just an example, use any auth mechanism you like


    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
