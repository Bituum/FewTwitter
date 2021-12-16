package com.example.twitt.config.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenUtil jwtTokenUtil;

    public JwtConfigurer(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void configure(HttpSecurity security) throws Exception {
        JwtFilter jwtFilter = new JwtFilter(jwtTokenUtil);
        security.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
