package cn.ahpu.springmvc.test;

import cn.ahpu.springmvc.dao.BookDao;
import cn.ahpu.springmvc.dao.JdbcEmpDao1;
import cn.ahpu.springmvc.pojo.Emp;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class testdemo1  {
    @Test
    public void test(){
        String conf="spring-mvc.xml";
        AbstractApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        JdbcEmpDao1 s=ac.getBean(JdbcEmpDao1.class);



        Emp emp1=s.findByNo(2);
        System.out.println(emp1.getDeptno());
        List<Emp> emps=s.findAll();

        for(Emp emp:emps){
            System.out.println(
                    emp.getEmpno()+","+
                    emp.getName()+","+
                    emp.getJob()+","+
                    emp.getMgr()+","+
                    emp.getHiredate()+","+
                    emp.getSal()+","+
                    emp.getComm()+","+
                    emp.getDeptno()
                    );
        }



}
}
