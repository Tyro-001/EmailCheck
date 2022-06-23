package com.Jin.control;

import com.Jin.Dao.MessageDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EmailController {

    @Autowired
    MessageDaoImpl messageDao;

    @RequestMapping("/gets")
    public void gets(@RequestParam("userEmail")String userEmail) throws MessagingException {

        messageDao.getMessage(userEmail);   //执行发送邮件

    }

    @RequestMapping("/check")
    public String check(@RequestParam("userNum") String userNum, Model model){

        boolean flag = messageDao.checkMessage(userNum);

        if(flag){
            return "success";
        }else {
            model.addAttribute("msg","验证码错误！");
            model.addAttribute("flag",false);
            return "";
        }

    }

}
