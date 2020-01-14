package cn.ahpu.springmvc.controller;

import cn.ahpu.springmvc.dao.BookDao;
import cn.ahpu.springmvc.dao.UserDao;
import cn.ahpu.springmvc.pojo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("")
public class loginController  {
    @Resource
    private UserDao userDao;
    @Resource
    private BookDao bookDao;


    @RequestMapping("/password-change")
    public ModelAndView pass(){
        ModelAndView mv = new ModelAndView("password-change");
        return mv;
    }
    @RequestMapping("/address-add")
    public ModelAndView addressadd(){
        ModelAndView mv = new ModelAndView("address-add");
        return mv;
    }
    @RequestMapping("/addressadd")
    @ResponseBody
    public String  address(String receiver, String address,String receiverPhone ,HttpServletRequest request){
        User user  = (User)request.getSession().getAttribute("user");
        String user_id = user.getPhone();
        String msg=null;
        //封装数据
        cn.ahpu.springmvc.pojo.address add = new address();
        add.setUser_id(user_id);
        add.setReceiver(receiver);
        add.setAddress(address);
        add.setReceiver_phone(receiverPhone);
        add.setAdded(new Date());
        boolean isAdd = bookDao.insert(add);
        if(isAdd==true){
            msg="yes";
        }else {
            msg="no";
        }
        return msg;



    }

    @RequestMapping("/addcollect")
    @ResponseBody
    public String  addcollect(String product ,HttpServletRequest request){
        User user  = (User)request.getSession().getAttribute("user");


        String user_id = user.getPhone();
        collect collect1=new collect();
        collect1.setProduct(product);
        collect1.setUser_id(user_id);
        Boolean bool=bookDao.insert(collect1);
        System.out.println(user_id);
        System.out.println(product);
        String msg=null;
        System.out.println(bool);


        if(bool==true){
            msg="yes";
        }else {
            msg="no";
        }
        return msg;



    }
    @RequestMapping("/addcart")
    @ResponseBody
    public String  addcart(String product,Integer count,HttpServletRequest request){
        User user  = (User)request.getSession().getAttribute("user");

        String user_id = user.getPhone();
        cart cart1=new cart();
        cart1.setCount(count);
        cart1.setProduct(product);
        cart1.setUser_id(user_id);

        Boolean bool=bookDao.insert(cart1);
        System.out.println(count);
        String msg=null;

        if(bool==true){
            msg="yes";
        }else {
            msg="no";
        }
        return msg;



    }




    @RequestMapping("/delete")
    @ResponseBody
    public ModelAndView  delete(String  rid,HttpServletRequest request){
        System.out.println(rid);
        Boolean bool=bookDao.delete(rid);
        System.out.println(bool);
        if(bool==true){
            ArrayList<cart> cart = bookDao.findAllProduct();
            Map<String,Object> data= new HashMap<String, Object>();
            data.put("cart",cart);
            return new ModelAndView("cart",data);
        }else {
            ArrayList<cart> cart = bookDao.findAllProduct();
            Map<String,Object> data= new HashMap<String, Object>();
            data.put("cart",cart);
            return new ModelAndView("cart",data);
        }



    }

    @RequestMapping("/collect")
    public ModelAndView collect(){
        ArrayList<collect> collects=bookDao.findAllcollect();
        Map<String,Object> data= new HashMap<String, Object>();
        data.put("collect",collects);
        return new ModelAndView("collect",data);

    } @RequestMapping("/order")
    public ModelAndView order(){
        ModelAndView mv = new ModelAndView("order");
        return mv;
    }  @RequestMapping("/lookforward")
    public ModelAndView lookforward(){
        ModelAndView mv = new ModelAndView("lookforward");
        return mv;
    }
    @RequestMapping("/login")
    public ModelAndView login1() {
        ModelAndView mv = new ModelAndView("login1");
        return mv;

    }
    @RequestMapping("/login.do")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login1");
        return mv;

    }
    @RequestMapping("/index")
    public ModelAndView index() {

        ArrayList<Book> books = bookDao.findAllBook();
        Map<String,Object> data= new HashMap<String, Object>();
        data.put("books",books);
        return new ModelAndView("index",data);

    }
    @RequestMapping("/cart")
    public ModelAndView cart() {

        ArrayList<cart> cart = bookDao.findAllProduct();
        Map<String,Object> data= new HashMap<String, Object>();
        data.put("cart",cart);
        return new ModelAndView("cart",data);

    }

    @RequestMapping("/dologin.do")
    public ModelAndView dologin(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
        String uname= req.getParameter("uname");
        String upwd= req.getParameter("upwd");
        System.out.println(uname);
        System.out.println(upwd);
        int role=0;
        User user = userDao.Select(uname, upwd,0);


        if(user==null){
            return  new ModelAndView("error");
        }
        else {
            req.getSession().setAttribute("user", user);
            ArrayList<Book> books = bookDao.findAllBook();
            Map<String,Object> data= new HashMap<String, Object>();
            data.put("books",books);
            return new ModelAndView("index",data);
            }
        }
        @RequestMapping("/S.do")
        public ModelAndView selectbyid(String isbn){
            System.out.println(isbn);
            ModelAndView mav = new ModelAndView();
             Book book=bookDao.selectBookByIsbn(isbn);
            System.out.println(book.getAuthor());
             mav.setViewName("detail");
             mav.addObject("book",book);
             return mav;


        }


//        public void updatepwd(HttpServletRequest req){
//        User user= (User) req.getSession().getAttribute("user");
//        String npwd=req.getParameter("npwd");
//
//        }
  //  }


    //ModelMap
//    public String tologin(String uname, String upwd, ModelMap modelMap){
//        int role=0;
//        User user=userDao.Select(uname,upwd,role);
//        if(user!=null){
//            modelMap.addAttribute("user",user);
//            return "dologin";
//        }else {
//            return "error";
//        }
//    }
//}


//    public String dologin(@ModelAttribute("uname") String uname, @ModelAttribute("upwd") String upwd) {
//        return "dologin";
//    }
//
//    @ModelAttribute("get")
//    public String ec() {
//        return "123";
//    }
//}


//    public String dologin(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException {
//        String uname = req.getParameter("uname");
//        String upwd = req.getParameter("upwd");
//        System.out.println(uname);
//        System.out.println(upwd);
//        int role = 0;
//        User user = userDao.Select(uname, upwd, 0);
//        if (user == null) {
//            return "error";
//        } else {
//            req.getSession().setAttribute("user", user);
//            ArrayList<Book> books = bookDao.findAllBook();
//            req.setAttribute("books", books);
////            try {
////                req.getRequestDispatcher("/dologin.do").forward(req, res);
////            } catch (ServletException e) {
////                e.printStackTrace();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            return "index";
//        }
//
//    }}




//    public void AllBook(HttpServletResponse res,HttpServletRequest req){
//        ArrayList<Book> books=bookDao.findAllBook();
//        req.setAttribute("books",books);
//        try {
//            req.getRequestDispatcher("../page/index.jsp").forward(req, res);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
// }



    //形参
//    public String tologin(String uname,@RequestParam("upwd") String password){
//        System.out.println(uname);
//       System.out.println(password);
//        return "dologin";
//    }



//自动封装bean
//    public String tologin(User user){
//        System.out.println(user.getUname());
//        System.out.println(user.getUpwd());
//        System.out.println(user.getEmail());
//        System.out.println(user.getPhone());
//        System.out.println(user.getRole());
//        return "dologin";
//    }
@RequestMapping("/pass")
@ResponseBody
public String ajax4(String upwd, HttpServletRequest req) {

    String msg=null;
    User loginUser = (User)req.getSession().getAttribute("user");
    if(loginUser.getUpwd().equals(upwd)){
        msg="yes";
    }else {
        msg="no";
    }
    return msg;
}

    @RequestMapping("/pass1")
    @ResponseBody
    public String ajax5(String npwd,String cpwd) {

        String msg=null;

        if(cpwd.equals(npwd)){
            msg="yes";
        }else {
            msg="no";
        }
        return msg;
    }
    @RequestMapping("/pass2")
    @ResponseBody
    public String ajax6(String npwd ,HttpServletRequest req) {
        User loginUser = (User)req.getSession().getAttribute("user");
        Boolean bool=bookDao.update(npwd,loginUser.getUname());
        String msg=null;
        if(bool==true){
            msg="yes";
        }else {
            msg="no";
        }
        return msg;
    }
}

