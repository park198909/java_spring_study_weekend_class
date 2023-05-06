package org.koreait.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.koreait.models.user.LoginFailureHandler;
import org.koreait.models.user.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/user/login")
                .usernameParameter("userId")
                .passwordParameter("userPw")
                //.defaultSuccessUrl("/")
                .successHandler(new LoginSuccessHandler())
                //.failureUrl("/user/login")
                .failureHandler(new LoginFailureHandler())
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/user/login");

        http.authorizeHttpRequests()
                //.requestMatchers("/mypage/**").authenticated() // 회원전용
                .requestMatchers("/admin/**").hasAuthority("ADMIN") // 관리자 전용
                .anyRequest().permitAll(); // 나머지는 전체 가능
        
        // 회원 전용 페이지에 비회원이 접근 -> 로그인 페이지 이동
        // 관리자페이지 -> 비회원이든 회원이든 권한 없는 경우 -> 401 권한 없음 응답 코드, 오류 페이지 이동
        http.exceptionHandling()
                .authenticationEntryPoint((req, res, e)->{
                    String redirectURL = req.getContextPath()+"/user/login";    // 로그인창으로 이동
                    String URI = req.getRequestURI();
                    if (URI.indexOf("/admin") != -1) {  // 관리자페이지로 이동
                        redirectURL = req.getContextPath()+"/error/401";
                    }
                    
                    res.sendRedirect(redirectURL);
                });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
