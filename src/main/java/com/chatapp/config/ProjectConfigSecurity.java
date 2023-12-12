package com.chatapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfigSecurity {
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
                                requestMatchers("/getChatPage").authenticated())
                .formLogin(loginConfigurer ->
                        loginConfigurer.defaultSuccessUrl("/getSignUpPage").failureUrl("/getSignUpPage?error=true")
                                .permitAll())
                .logout(logoutConfigurrer -> {
                    logoutConfigurrer.logoutSuccessUrl("/getSignUpPage?error=true")
                            .invalidateHttpSession(true)
                            .permitAll();
                }).formLogin(Customizer.withDefaults());


        return http.build();
    }

}
