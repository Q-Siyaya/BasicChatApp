package com.chatapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Data
public class ChatRoom extends BaseEntity
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native")
    private int chatRomId;

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Geek.class,cascade = {CascadeType.PERSIST,
    CascadeType.REFRESH})
    @JoinColumn(name = "geek_fk",referencedColumnName = "chatRomId",nullable = true)
    private List<Geek> geeks;


    @OneToMany(fetch = FetchType.EAGER,targetEntity = Message.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "message_fk",referencedColumnName = "chatRomId")
    List<Message> messages;


}
