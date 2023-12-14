use chatdatabase;


CREATE TABLE IF NOT EXISTS `geek` (
  `geek_id` int AUTO_INCREMENT  PRIMARY KEY,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `chat_status` varchar(100) ,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `messages_fk` int DEFAULT NULL,
  `created_at` TIMESTAMP DEFAULT NULL,
  `last_updated_at` TIMESTAMP DEFAULT NULL
);


ALTER TABLE geek
ADD CONSTRAINT fk_messages
FOREIGN KEY (messages_fk) REFERENCES contact_msg(message_id);



CREATE TABLE IF NOT EXISTS `message` (
  `message_id` int AUTO_INCREMENT  PRIMARY KEY,
  `message_text` VARCHAR(255) DEFAULT 'Not Received',
  `time_received` TIMESTAMP,
  `msg_status` VARCHAR(500) DEFAULT 'Not Received',
  `sender_fk` int NOT NULL,
  `receiver_fk` int NOT NULL,
  `created_at` TIMESTAMP NOT ,
  `last_updated_at` TIMESTAMP DEFAULT NULL,
  FOREIGN KEY ('sender_fk') REFERENCES geek ('geek_id'),
  FOREIGN KEY ('receiver_fk') REFERENCES geek ('geek_id')
);
