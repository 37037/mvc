package cn.ahpu.springmvc.interceptor;

import cn.ahpu.springmvc.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Userinterceptor implements HandlerInterceptor {
    private static String AUTH_SESSION_USER_KEY="userInfo";//从session中获取userInfo

    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse res,
                             Object o) throws Exception {
        /* 处理器handlerMapping执行之前调用，方法返回true放行false中断请求*/
        String url = req.getServletPath();
        System.out.println("post URL："+url);
        if(!url.equals("")){
            System.out.println(">>>登录，請重新登录<<<");
            //判斷是否已登录
            User loginUser = (User)req.getSession().getAttribute("user");
            if(loginUser == null){
                //無session則是未登录狀態
                System.out.println(">>>未登录，請重新登录<<<");
                res.sendRedirect("/SprinMvc_Login_war_exploded/login.do");
                return false;
            }
//            ServletContext ctx=req.getSession().getServletContext();
//            res.sendRedirect(ctx.getContextPath()+"/login.do");
        }
        return true;
        //return super.preHandle(request, response, handler);


    }

    @Override
    public void postHandle(HttpServletRequest req,
                           HttpServletResponse res,
                           Object o, ModelAndView modelAndView) throws Exception {
        /*处理器执行完毕之后，视图解析器之前调用此时可以对处理器的结果或试图进行操作
        * 通过Modelandview操作
        * */
    }

    @Override
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse res,
                                Object o, Exception e) throws Exception {
        /*
        * 整个流程处理完毕之后调用，一般可以监控消耗时间进行资源的清理等；
        *
        * */

    }
}
