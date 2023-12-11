package com.chatapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfigSecurity {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf(auth->
                auth.ignoringRequestMatchers("/getSignUpPage")
                        .ignoringRequestMatchers("/createUser"))
                .authorizeHttpRequests(request->
                        request.requestMatchers("","/","/home").permitAll().
                        requestMatchers("/getChatPage").authenticated())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

}
