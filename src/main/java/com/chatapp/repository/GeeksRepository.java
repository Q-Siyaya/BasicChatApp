package com.chatapp.repository;

import com.chatapp.model.Geek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeeksRepository extends JpaRepository<Geek,Integer> {
    Geek findByEmail(String email);
}
