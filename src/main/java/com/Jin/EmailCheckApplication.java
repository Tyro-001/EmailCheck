package com.Jin;

import com.Jin.Dao.MessageDaoImpl;
import com.Jin.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootApplication
public class EmailCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailCheckApplication.class, args);
    }


}
