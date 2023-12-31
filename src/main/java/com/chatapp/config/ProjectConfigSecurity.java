package com.chatapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class
ProjectConfigSecurity {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(auth ->
                        auth.ignoringRequestMatchers("/getSignUpPage")
                                .ignoringRequestMatchers("/createUser")
                )
                .authorizeHttpRequests(request ->
                        request.requestMatchers(path -> {
                                    String pathReq = path.getContextPath();
                                    return pathReq.equals("") || pathReq.equals("/") || pathReq.equals("/home");

                                }).permitAll().
                                requestMatchers("/login/**").permitAll()
                                .requestMatchers("/getChatPage").authenticated())
                .formLogin(loginConfigurer ->
                        loginConfigurer.defaultSuccessUrl("/getChatPage").failureUrl("/login?error=true")
                                .permitAll())
                .logout(logoutConfigurrer -> {
                    logoutConfigurrer.logoutSuccessUrl("/login?logout=true")
                            .invalidateHttpSession(true)
                            .permitAll();
                }).formLogin(Customizer.withDefaults());


        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
