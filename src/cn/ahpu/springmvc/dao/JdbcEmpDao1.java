package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.Emp;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class JdbcEmpDao1 extends JdbcDaoSupport implements EmpDao {

    @Override
    public void save(Emp emp) {
        String sql="insert into t_emp value(?,?,?,?,?,?,?,?) ";
        Object[] params={
                emp.getEmpno(),
                emp.getName(),
                emp.getJob(),
                emp.getMgr(),
                emp.getHiredate(),
                emp.getSal(),
                emp.getComm(),
                emp.getDeptno()
                        };
        super.getJdbcTemplate().update(sql,params);

    }

    @Override
    public void update(String ename, Integer sal, String job, int empno) {

    }









    @Override
    public void delete(int empno) {
        String sql="delete from t_emp where empno=?";
        super.getJdbcTemplate().update(sql,empno);

    }

    @Override
    public Emp findByNo(int empno) {
        String sql="select * from t_emp where empno=?";
        RowMapper<Emp> mapper=new EmpMapper();
        Emp emp=super.getJdbcTemplate().queryForObject(sql,mapper,empno);
        return emp;

    }

    @Override
    public List<Emp> findAll() {
        String sql="select * from t_emp";
        RowMapper<Emp> mapper=new EmpMapper();
        List<Emp> emps =super.getJdbcTemplate().query(sql,mapper);
        return emps;

    }
}
