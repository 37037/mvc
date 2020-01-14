package cn.ahpu.springmvc.dao;

import cn.ahpu.springmvc.pojo.Book;
import cn.ahpu.springmvc.pojo.address;
import cn.ahpu.springmvc.pojo.cart;

import cn.ahpu.springmvc.pojo.collect;
import cn.ahpu.springmvc.util.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@Repository
public class BookDao {
    private JdbcDataSource jdbcDataSource;

    public BookDao() {
    }

    public BookDao(JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }


    @Autowired
    public void setJdbcDataSource(@Qualifier("jdbcDataSource") JdbcDataSource jdbcDataSource) {
        this.jdbcDataSource = jdbcDataSource;
    }
    public ArrayList<Book> findAllBook() {
        /**创建一个空的集合
         *   获得连接
         *   执行sql
         *   处理结果集(拿到每一条的记录，用这一条记录的各个字段
         *           封装出一个book对象，然后添加到集合中)
         * 返回这个集合
         */
        ArrayList<Book> books = new ArrayList<Book>();
        Connection con = jdbcDataSource.getCon();
        String sql = "select * from tb_book";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                String press = rs.getString("press");
                int edition = rs.getInt("edition");
                java.util.Date published = rs.getDate("published");
                int pages = rs.getInt("pages");
                int words = rs.getInt("words");
                String packaging = rs.getString("packaging");
                String format = rs.getString("format");
                String form = rs.getString("form");
                Book book = new Book(isbn, title, author, price, press, edition, published, pages, words, packaging, format, form);
                books.add(book);
                //在AllBookServlet中通过dao得到集合，输出  集合.size()试试？？？？
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);
        }

        return books;
    }
    public Book selectBookByIsbn(String isbn) {
        Book book=null;
        Connection con = jdbcDataSource.getCon();
        String sql = "select * from tb_book where isbn=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,isbn);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {

                String title = rs.getString("title");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                String press = rs.getString("press");
                int edition = rs.getInt("edition");
                java.util.Date published = rs.getDate("published");
                int pages = rs.getInt("pages");
                int words = rs.getInt("words");
                String packaging = rs.getString("packaging");
                String format = rs.getString("format");
                String form = rs.getString("form");
                book = new Book(isbn, title, author, price, press, edition, published, pages, words, packaging, format, form);

                //在AllBookServlet中通过dao得到集合，输出  集合.size()试试？？？？
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           jdbcDataSource.getCon();
        }
        return book;
    }


    public Boolean update(String npwd, String uname) {
        Connection con = jdbcDataSource.getCon();
        String sql = "update tb_user set upwd=? where uname=?";
        PreparedStatement ps = null;
        boolean bool=false;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,npwd);
            ps.setString(2,uname);
            if(ps.executeUpdate()==1){
                bool=true;
            }else {
                bool=false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.getCon();
        }
        return bool;
    }
    public Boolean insert(address address) {
        Connection con = jdbcDataSource.getCon();
        boolean flag = false;
        String sql = "insert into tb_address"
                + "(user_id,address,added,receiver,receiver_phone) "
                + "values(?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,address.getUser_id());
            ps.setString(2, address.getAddress());
            ps.setDate(3, new java.sql.Date(address.getAdded().getTime()));
            ps.setString(4, address.getReceiver());
            ps.setString(5, address.getReceiver_phone());
            //影响的行数
            int row = ps.executeUpdate();
            if(row==1) {
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);

        }
        return flag;

    }



    public Boolean insert(cart cart) {
        Connection con = jdbcDataSource.getCon();
        boolean flag = false;
        String sql = "insert into tb_cart_item"
                + "(user_id,product,count ) "
                + "values(?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cart.getUser_id());
            ps.setString(2,cart.getProduct());
            ps.setInt(3, cart.getCount());

            //影响的行数
            int row = ps.executeUpdate();
            if(row==1) {
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);

        }
        return flag;

    }
    public Boolean insert(collect collect) {
        Connection con = jdbcDataSource.getCon();
        boolean flag = false;
        String sql = "insert into tb_collect(user_id,product) values(?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,collect.getUser_id());
            ps.setString(2,collect.getProduct());



            //影响的行数
            int row = ps.executeUpdate();
            if(row==1) {
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);

        }
        return flag;

    }


    public Boolean delete(String  rid) {
        Connection con = jdbcDataSource.getCon();
        boolean flag = false;
        String sql = "delete from tb_cart_item where rid = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,rid);
            //影响的行数
            int row = ps.executeUpdate();
            if(row==1) {
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);

        }
        return flag;

    }



    public ArrayList<cart> findAllProduct() {
        /**创建一个空的集合
         *   获得连接
         *   执行sql
         *   处理结果集(拿到每一条的记录，用这一条记录的各个字段
         *           封装出一个book对象，然后添加到集合中)
         * 返回这个集合
         */
        ArrayList<cart> carts = new ArrayList<>();
        Connection con = jdbcDataSource.getCon();
        String sql = "select * from tb_cart_item";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer rid = rs.getInt("rid");
                String user_id = rs.getString("user_id");
                String product = rs.getString("product");
                Integer count = rs.getInt("count");
                cart Cart = new cart(rid,user_id,product,count);
                carts.add(Cart);
                //在AllBookServlet中通过dao得到集合，输出  集合.size()试试？？？？
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);
        }

        return carts;
    }

    public ArrayList<collect> findAllcollect() {
        /**创建一个空的集合
         *   获得连接
         *   执行sql
         *   处理结果集(拿到每一条的记录，用这一条记录的各个字段
         *           封装出一个book对象，然后添加到集合中)
         * 返回这个集合
         */
        ArrayList<collect> collects = new ArrayList<>();
        Connection con = jdbcDataSource.getCon();
        String sql = "select * from tb_collect";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Integer rid = rs.getInt("rid");
                String user_id = rs.getString("user_id");
                String product = rs.getString("product");

                collect collect1 = new collect(user_id,product,rid);
                collects.add(collect1);
                //在AllBookServlet中通过dao得到集合，输出  集合.size()试试？？？？
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcDataSource.close(con);
        }

        return collects;
    }

}
