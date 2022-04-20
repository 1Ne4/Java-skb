package com.example.homework10;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api").hasAnyRole("ADMIN")
                .antMatchers("/support/api").hasAnyRole("SUPPORT")
                .anyRequest().permitAll().and().formLogin().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var admin = User.withUsername("admin")
                .passwordEncoder(encoder::encode)
                .password("123").roles("ADMIN").build();

        var support = User.withUsername("support").passwordEncoder(encoder::encode)
                .password("sup").roles("SUPPORT").build();

        InMemoryUserDetailsManager uds = new InMemoryUserDetailsManager(admin, support);
        auth.userDetailsService(uds).passwordEncoder(encoder);
    }
}
