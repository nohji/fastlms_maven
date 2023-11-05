package com.zerobase.fastlms.fastlms.configuration;

import com.zerobase.fastlms.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration  {

    private final MemberService memberService;

    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    UserAuthenticationFailureHandler getFailureHandler(){
        return new UserAuthenticationFailureHandler();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authorize ->
                    authorize
                            .requestMatchers("/"
                                    ,"/member/register"
                                    , "/member/email-auth"
                                    , "/member/find-password"
                                    , "/member/reset/password").permitAll()
                            .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/member/login")
                    .failureHandler(getFailureHandler())
                    .permitAll()
            )
            .logout((logout) -> logout
            .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true))
        ;

        return http.build();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(memberService);
        provider.setPasswordEncoder(getPasswordEncoder());
        return provider;
    }


}
