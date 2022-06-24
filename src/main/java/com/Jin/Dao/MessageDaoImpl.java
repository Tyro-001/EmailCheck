package com.Jin.Dao;

import com.Jin.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Repository
@Service
public class MessageDaoImpl implements MessageDao{


    static RandomUtil random = new RandomUtil();    //随机数工具
    static String nums = random.getNum();       //获取随机数验证码


    @Autowired
    JavaMailSenderImpl mailSender;

    //获取验证码
    @Override
    @Async      //异步方法
    public void getMessage(@RequestParam("userEmail")String userEmail)  throws MessagingException {
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

        helper.setTo(userEmail);
        helper.setFrom("2465010243@qq.com");

        mailSender.send(mimeMailMessage);
        System.out.println(nums);
    }

    //效验验证码
    @Override
    public boolean checkMessage(@RequestParam("userNum") String userNum) {

        if(userNum!=null){

            if (userNum == nums ){
                return true;
            }else {
                return false;
            }

        }
        return false;

    }
}
