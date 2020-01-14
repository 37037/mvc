package cn.ahpu.springmvc.test;

import cn.ahpu.springmvc.util.JdbcDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test01(){
        String conf="spring-mvc.xml";
        ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
        JdbcDataSource data=ac.getBean(JdbcDataSource.class);
        System.out.println(data);

    }
}
