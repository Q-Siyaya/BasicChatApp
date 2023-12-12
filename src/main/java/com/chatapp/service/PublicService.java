package com.chatapp.service;

import com.chatapp.model.Geek;
import com.chatapp.repository.GeeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PublicService {

    @Autowired
    private GeeksRepository geeksRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createGeek(Geek geek)
    {
        geek.setPassword(passwordEncoder.encode(geek.getPassword()));

        geek=geeksRepository.save(geek);

       return geek !=null && geek.getGeekId()>0;

    }
}
