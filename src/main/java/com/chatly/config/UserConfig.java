package com.chatly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.chatly.model.User;
import com.chatly.repository.UserRepository;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .cors().and()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/user/**").permitAll()
        .antMatchers(HttpMethod.GET, "/swagger**").permitAll()
        .anyRequest().authenticated()
        .and().httpBasic()
        .and().authenticationProvider(authProvider());
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                User user = userRepository.getByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException(email));
                return user;
            }
        });
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}