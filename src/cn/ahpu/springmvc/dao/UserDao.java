package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.User;
import cn.ahpu.springmvc.util.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
    private JdbcDataSource jdbcDataSource;

    public UserDao() {
    }

    public UserDao(JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }


    @Autowired
    public void setJdbcDataSource(@Qualifier("jdbcDataSource") JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }
    public User Select(String uname,String upwd,int role){
        User user=null;
        Connection con=jdbcDataSource.getCon();
        String sql= "select * from tb_user where uname=? and upwd=? and role=?";
        PreparedStatement ps=null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, upwd);
            ps.setInt(3, role);
            ResultSet rs = ps.executeQuery();
            //游标，初始位置是第0行，rs.next()，可以往下移动游标，返回boolean
            if(rs.next()) {
                user = new User();
                user.setUname(rs.getString("uname"));
                user.setUpwd(rs.getString("upwd"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getInt("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);
        }
        return user;
    }
    public boolean updatepwd(User user,String npwd)  {
        Connection con=jdbcDataSource.getCon();
         String sql="update tb_user set upwd=? where user=?";
        PreparedStatement ps=null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,npwd);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        jdbcDataSource.close(con);
        return true;


    }
}
