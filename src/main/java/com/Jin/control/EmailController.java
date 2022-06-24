package com.Jin.control;

import com.Jin.Dao.MessageDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class EmailController {

    @Autowired
    MessageDaoImpl messageDao;

//    @RequestMapping("/gets")
//    public void gets(@RequestParam("userEmail") String userEmail) throws MessagingException {
//        messageDao.getMessage(userEmail);   //执行发送邮件
//        System.out.println(userEmail+" has received");
//    }

    @ResponseBody
    @RequestMapping(value = "/gets")
    public String gets(HttpServletRequest request,HttpServletResponse response) throws MessagingException, ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userNum = request.getParameter("userNum");

        if(userNum == null){
            messageDao.getMessage(userEmail);
            System.out.println(userEmail+" has received");
        }else {
            request.getRequestDispatcher("/check").forward(request,response);
            request.setAttribute("userEmail",userEmail);
            request.setAttribute("userNum",userNum);
        }

        return userEmail+"：验证码已发送，请注意查收，查收后请返回上一级填写验证码。";
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String check(HttpServletRequest request){
        String userEmail = request.getParameter("userEmail");
        String userNum = request.getParameter("userNum");
        boolean flag = messageDao.checkMessage(userNum);

        System.out.println(userNum);
        System.out.println(userEmail);
        if(flag){
            return "success";
        }else {
            request.setAttribute("msg","验证码错误！");
            request.setAttribute("flag",false);
            return "index";
        }

    }

//    @RequestMapping(value = "/check",method = RequestMethod.POST)
//    public void test(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        String userNum = request.getParameter("userNum");   //接收参数
//        boolean flag = messageDao.checkMessage(userNum);
//
//        System.out.println(userNum);
//        if(flag){                                                   //验证正确
//            request.getRequestDispatcher("/success.html").forward(request,response);
//        }else {
//            request.setAttribute("msg","验证码错误！");
//            request.setAttribute("flag",false);
//        }
//    }

}
