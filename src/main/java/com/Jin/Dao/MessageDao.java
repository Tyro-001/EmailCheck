package com.Jin.Dao;

import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

public interface MessageDao {

    //获取验证码
    public void getMessage(@RequestParam("userEmail") String userEmail)throws MessagingException;


    //效验验证码
    public boolean checkMessage(@RequestParam("userNum") String userNum);

}
