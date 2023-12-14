package com.chatapp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;

@Entity
@Data
public class Message extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private int messageId;

    private String messageText;

    @Column(insertable = false,nullable = true,updatable = true)
    private LocalDateTime timeReceived;


    @Column(insertable = false,columnDefinition = "default 'Not Received'")
    private String msgStatus;


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_fk",referencedColumnName = "geekId")
    private Geek sender;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "reciever_fk",referencedColumnName = "geekId")
    private Geek recipient;


}
