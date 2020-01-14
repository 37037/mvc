package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.Emp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmpMapper implements RowMapper<Emp> {

    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp=new Emp();
        emp.setName(resultSet.getString("ename"));
        emp.setMgr(resultSet.getInt("mgr"));
        emp.setJob(resultSet.getString("job"));
        emp.setHiredate(resultSet.getDate("hiredate"));
        emp.setEmpno(resultSet.getInt("empno"));
        emp.setSal(resultSet.getInt("sal"));
        emp.setComm(resultSet.getInt("comm"));
        emp.setDeptno(resultSet.getInt("deptno"));


        return emp;
    }
}
