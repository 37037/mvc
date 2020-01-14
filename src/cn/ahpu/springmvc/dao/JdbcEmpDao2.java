package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.Emp;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class JdbcEmpDao2 implements EmpDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        this.jdbcTemplate.update(sql,params);

    }

    @Override
    public void update(String ename,Integer sal,String job, int empno) {
        String sql="update t_emp set ename=?,sal=?,job=? where empno=?";

        this.jdbcTemplate.update(sql,ename,sal,job,empno);

    }

    @Override
    public void delete(int empno) {
        String sql="delete from t_emp where empno=?";
       this.jdbcTemplate.update(sql,empno);

    }

    @Override
    public Emp findByNo(int empno) {
        String sql="select * from t_emp where empno=?";
        RowMapper<Emp> mapper=new EmpMapper();
        Emp emp=this.jdbcTemplate.queryForObject(sql,mapper,empno);
        return emp;

    }

    @Override
    public List<Emp> findAll() {
        String sql="select * from t_emp";
        RowMapper<Emp> mapper=new EmpMapper();
        List<Emp> emps =this.jdbcTemplate.query(sql,mapper);
        return emps;

    }
}
