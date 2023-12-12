package com.chatapp.security;

import com.chatapp.model.Geek;
import com.chatapp.repository.GeeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class ChatAppPwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private GeeksRepository geeksRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email=authentication.getName().trim();
        String pwd=authentication.getCredentials().toString().trim();

        Geek geek =geeksRepository.findByEmail(email);

        if(geek !=null && email.equals(geek.getEmail().trim()) &&
                passwordEncoder.matches(pwd.trim(), geek.getPassword().trim()))
        {
            return new UsernamePasswordAuthenticationToken(email,null);
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
