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

    @OneToMany(fetch = FetchType.EAGER,targetEntity = Geeks.class,cascade = {CascadeType.PERSIST,
    CascadeType.REFRESH})
    @JoinColumn(name = "Geek_FK",referencedColumnName = "geekId",nullable = true)
    private List<Geeks> geeks;


    @OneToMany(fetch = FetchType.EAGER,targetEntity = Message.class,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "messageId")
    List<Message> messages;


}
