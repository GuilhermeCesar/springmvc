package org.casadocodigo.loja.conf;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/carrinho/**").permitAll()
                .antMatchers("/pagamentos/**").permitAll()
                .antMatchers("/produtos/form").hasRole("ADMIN")
                .antMatchers("/carrinho").permitAll()
                .antMatchers(HttpMethod.POST,"/produtos").hasRole("ADMIM")
                .antMatchers(HttpMethod.GET,"/produtos").hasRole("ADMIN")
                .antMatchers("/produtos/**").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
