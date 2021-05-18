package com.example.camunda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

   /* @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("demo").password("demo").roles("ACTUATOR", "camunda-admin").build());
        manager.createUser(User.withUsername("ms-fraud").password("ms-fraud").roles("task-worker-bpmn-error").roles("task-worker").build());
        manager.createUser(User.withUsername("ms-application-scanner").password("ms-application-scanner").roles("workflow-starter").build());
        manager.createUser(User.withUsername("ms-credit").password("ms-credit").roles("task-worker").build());
        manager.createUser(User.withUsername("ms-contract").password("ms-contract").roles("task-worker").build());


        return manager;
    }*/

}
