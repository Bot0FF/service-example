package org.ibs.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        String indexUrl = "/swagger-ui/index.html?configUrl=/api/v2/api-docs/swagger-config#";

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").hasRole("READER")
                .antMatchers(HttpMethod.DELETE, "/v2/employees").hasRole("WRITER")
                .antMatchers(HttpMethod.POST, "/v2/employees").hasRole("WRITER")
                .and()
                .formLogin()
                .defaultSuccessUrl(indexUrl, true);
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userR = User.withDefaultPasswordEncoder()
                .username("reader")
                .password("123")
                .roles("READER")
                .build();

        UserDetails userW = User.withDefaultPasswordEncoder()
                .username("q")
                .password("q")
                .roles("WRITER", "READER")
                .build();

        return new InMemoryUserDetailsManager(userR, userW);
    }
}
