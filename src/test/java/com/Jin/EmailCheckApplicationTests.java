package com.Jin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class EmailCheckApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
    }
    @Test
    public void test() throws MessagingException {
//        String nums = random.getNum();
        String nums = "946326";
        //复杂邮件
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

        helper.setSubject("原神邮箱验证");
        helper.setText("<p>您好，您正在进行邮箱验证。</p>" +
                        "<p>您的验证码：<strong>" + nums +"</strong></p>" +
                        "<p>如果并非本人操作，请忽略。</p>" +
                        "</br>" +
                        "<p>--- author: Jin</p>"
                ,true);

        helper.setTo("2465010243@qq.com");
        helper.setFrom("2465010243@qq.com");

        mailSender.send(mimeMailMessage);
        System.out.println(nums);
    }

}
