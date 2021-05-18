package com.example.camunda.config;

import org.camunda.bpm.webapp.impl.security.auth.ContainerBasedAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@EnableWebSecurity
@Order(15)

public class WebApplicationsSecurityConfig extends WebSecurityConfigurerAdapter {

      @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/app/**")
                .authorizeRequests()
                .anyRequest().hasRole("camunda-admin").and().httpBasic();




    }





 /*   @Bean
    public FilterRegistrationBean containerBasedAuthenticationFilter () {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new ContainerBasedAuthenticationFilter());
        filterRegistration.setInitParameters(Collections.singletonMap("authentication-provider", "com.example.camunda.filter.webapp.SpringSecurityAuthenticationProvider"));
        filterRegistration.setOrder(101);
        filterRegistration.addUrlPatterns("/app/**");
        return filterRegistration;
    }*/



}