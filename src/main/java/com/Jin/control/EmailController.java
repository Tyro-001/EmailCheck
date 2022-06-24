package com.Jin.control;

import com.Jin.Dao.MessageDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //发送验证码
    @ResponseBody
    @RequestMapping(value = "/gets")
    public String gets(HttpServletRequest request,HttpServletResponse response) throws MessagingException, ServletException, IOException {
        String userEmail = request.getParameter("userEmail");
        String userNum = request.getParameter("userNum");

        if(userNum.isEmpty()){
            System.out.println("正在发送email....");
            messageDao.getMessage(userEmail);
            System.out.println(userEmail+" has received");
        }else {
            request.setAttribute("userEmail",userEmail);
            request.setAttribute("userNum",userNum);
            System.out.println("正在检验.....");
            request.getRequestDispatcher("/check").forward(request,response);
//            response.sendRedirect("/check");

        }

        return userEmail+"：验证码已发送，请注意查收，查收后请返回上一级填写验证码。";
    }

    //效验
    @RequestMapping(value = "/check")
    public String check(HttpServletRequest request){
        String userEmail = request.getParameter("userEmail");
        String userNum = request.getParameter("userNum");
        System.out.println("前端参数: "+userNum);
        System.out.println("用户邮箱: "+userEmail);

        boolean flag = messageDao.checkMessage(userNum);
        if(flag){
            System.out.println("验证成功");
            return "success";
        }else {
            request.setAttribute("msg","验证码错误！");
            request.setAttribute("flag",false);
            System.out.println("验证失败");
            return "index";
        }

    }


}
