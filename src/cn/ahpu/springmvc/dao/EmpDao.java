package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.Emp;

import java.util.ArrayList;
import java.util.List;

public interface EmpDao {
    public void save(Emp emp);
    public void update(String ename,Integer sal,String job, int empno);
    public void delete(int empno );
    public Emp findByNo(int empno);
    public List<Emp> findAll();

}
