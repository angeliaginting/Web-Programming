package com.example.ppw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/favicon.ico",
                        "/*/.png",
                        "/*/.gif",
                        "/*/.svg",
                        "/*/.jpg",
                        "/*/.html",
                        "/*/.css",
                        "/*/.js")
                .permitAll()
                .antMatchers("/cart/**")
                .permitAll()
                .antMatchers("/api/auth/**")
                .permitAll()
                .antMatchers("/user/**")
                .permitAll()
                .antMatchers("/api/user/checkUsernameAvailability", "/api/user/checkEmailAvailability")
                .permitAll()
                .antMatchers("/cart/purchase/*")
                .permitAll()
                .antMatchers("/product/simpan1")
                .permitAll()
                .antMatchers("/merchant/saveProduct")
                .permitAll()
                .antMatchers("seqUser/**")
                .permitAll()
                .antMatchers("/shoppingcart/produk")
                .permitAll()
//                .anyRequest()
//                .authenticated()
        ;
    }
}
