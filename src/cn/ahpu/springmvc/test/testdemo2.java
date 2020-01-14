package cn.ahpu.springmvc.test;

import cn.ahpu.springmvc.dao.JdbcEmpDao2;
import cn.ahpu.springmvc.pojo.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class testdemo2 {
    @Test
    public void test(){
        String conf="spring-mvc.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        JdbcEmpDao2 jdbcEmpDao2=ac.getBean(JdbcEmpDao2.class);
//        Emp emp=new Emp();
//        emp.setEmpno(111);
//        emp.setDeptno(111);
//        emp.setComm(111);
//        emp.setSal(111);
//        emp.setHiredate(new Date());
//        emp.setJob("ewr");
//        emp.setMgr(1);
//        emp.setName("rt");
//        jdbcEmpDao2.save(emp);
        //jdbcEmpDao2.update("zb",111);
        List<Emp> emps=jdbcEmpDao2.findAll();

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
