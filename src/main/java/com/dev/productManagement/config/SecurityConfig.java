package com.dev.productManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
/*
* Security Version 5.7 이상
* WebSecurityConfigurerAdapter (Override) -> SecurityConfigurerAdapter (Bean)
 */
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement() // 세션관리
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true); // 동시로그인 방지 여부

        http.authorizeRequests()
                .antMatchers("/**").permitAll() // 접근 가능 설정
                    .anyRequest().authenticated() // '/' 제외한 모든 경로 인증필수
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll() // 로그인 페이지에 대한 접근 허용
                    .and()
                .logout()
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID"); // 쿠키 삭제

        return http.build();
    }


    // Encode
    /*
    @Bean
    public PasswordEncoder PasswordEncoder () {
    	return new BCryptPasswordEncoder();
    }

     */
}