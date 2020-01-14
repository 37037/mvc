package cn.ahpu.springmvc.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class JdbcDataSource {

    private String driver;
    @Value("#{jdbcPros.url}")
    private String url;
    @Value("#{jdbcPros.name}")
    private String uname;
    @Value("#{jdbcPros.pwd}")
    private String upwd;

    public String getDriver() {
        return driver;
    }
    @Value("#{jdbcPros.driverClassName}")
    public void setDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public JdbcDataSource() {
    }

    public JdbcDataSource(String driver, String url, String uname, String upwd) {
        this.driver = driver;
        this.url = url;
        this.uname = uname;
        this.upwd = upwd;
    }
    public Connection getCon(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(url,uname,upwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  con;
    }
    public void close( Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
