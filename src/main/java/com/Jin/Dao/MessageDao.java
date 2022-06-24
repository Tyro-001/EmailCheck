package com.Jin.Dao;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import javax.mail.MessagingException;

@Service
public interface MessageDao {

    //获取验证码
    @Async      //异步方法
    public void getMessage(@RequestParam("userEmail") String userEmail)throws MessagingException;


    //效验验证码

    public boolean checkMessage(@RequestParam("userNum") String userNum);

}
