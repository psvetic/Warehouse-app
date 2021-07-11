package com.psvetic.partsunlimited.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/products/**").hasAnyRole("SALES","CUSTOMER")
                .antMatchers("/parts/**").hasRole("WAREHOUSE")
                .antMatchers("/products/**").hasRole("SALES")
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("warehouse").password("{noop}skladište").roles("WAREHOUSE");
        auth.inMemoryAuthentication().withUser("sales").password("{noop}prodaja").roles("SALES");
        auth.inMemoryAuthentication().withUser("factory").password("{noop}tvornica").roles("FACTORY");
        auth.inMemoryAuthentication().withUser("customer").password("{noop}kupac").roles("CUSTOMER");
    }

}
