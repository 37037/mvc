package cn.ahpu.springmvc.controller;

import cn.ahpu.springmvc.pojo.User;
import cn.ahpu.springmvc.pojo.User1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse res) throws IOException {
        if("admin".equals(name)){
            res.getWriter().println("true");
        }else {
            res.getWriter().println("false");
        }

    }
       @RequestMapping("/a2")
    @ResponseBody
    public List<User1> ajax2() {

        List<User1> list=new ArrayList<>();
        User1 user1=new User1("zheng1",1);
        User1 user2=new User1("zheng2",11);
        User1 user3=new User1("zheng3",111);
        User1 user4=new User1("zheng4",1111);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return list;
    }
    @RequestMapping("/a3")
    @ResponseBody
    public String ajax3(String name,String pwd) {

       String msg=null;
       if(name!=null){
           if("admin".equals(name)){
               msg="ok";
           }else {
               msg="error";
           }
       }
        if(pwd!=null){
            if("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="error";
            }
        }
        return msg;
    }


}
