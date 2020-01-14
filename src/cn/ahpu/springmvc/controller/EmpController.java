package cn.ahpu.springmvc.controller;

import cn.ahpu.springmvc.dao.JdbcEmpDao2;
import cn.ahpu.springmvc.dao.UserDao;
import cn.ahpu.springmvc.pojo.Book;
import cn.ahpu.springmvc.pojo.Emp;
import cn.ahpu.springmvc.pojo.User;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {
    @Resource
    private UserDao userDao;
    @Resource
    private JdbcEmpDao2 jdbcEmpDao2;

    @RequestMapping("/regist1")
    public ModelAndView regist(){
        ModelAndView mv=new ModelAndView("regist1");
        return mv;
    }
    @RequestMapping("/updateEmp")
    public ModelAndView addEmp(){

        ModelAndView mv=new ModelAndView("updateEmp");
        return mv;
    }
    @RequestMapping("/addEmp")
    public ModelAndView addEmp1(){

        ModelAndView mv=new ModelAndView("addEmp");
        return mv;
    }
    @RequestMapping("/save")
    public ModelAndView save(String name,Integer salary,String job){
        Emp emp=new Emp();
        emp.setJob(job);
        System.out.println();
        emp.setSal(salary);
        emp.setName(name);
        jdbcEmpDao2.save(emp);
        List<Emp> emps=jdbcEmpDao2.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("emp",emps);

        return new ModelAndView("emplist",map);




    }
    @RequestMapping("/login2")
    public ModelAndView login2(){
        ModelAndView mv=new ModelAndView("login2");
        return mv;
    }
    @RequestMapping("/delete1")
    public ModelAndView delete1(Integer empno){
        jdbcEmpDao2.delete(empno);

        List<Emp> emps=jdbcEmpDao2.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("emp",emps);

        return new ModelAndView("emplist",map);



    }
    @RequestMapping("/update")
    public ModelAndView update(Integer empno,String name,Integer salary,String job){

       System.out.println(name);
       jdbcEmpDao2.update(name,salary,job,empno);
        System.out.println(name);
        List<Emp> emps=jdbcEmpDao2.findAll();
        Map<String,Object> map=new HashMap<>();
        map.put("emp",emps);
        return new ModelAndView("emplist",map);
    }

@RequestMapping("/emplist")
    public ModelAndView dologin(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
        String name= req.getParameter("name");
        String pwd= req.getParameter("pwd");

        System.out.println(name);
        int role=0;
        User user = userDao.Select(name, pwd,0);

        if(user==null){
            return  new ModelAndView("error");
        }
        else {
            req.getSession().setAttribute("user", user);
            List<Emp> emps=jdbcEmpDao2.findAll();

            Map<String,Object> map=new HashMap<>();
            map.put("emp",emps);

            return new ModelAndView("emplist",map);
        }
    }
}
