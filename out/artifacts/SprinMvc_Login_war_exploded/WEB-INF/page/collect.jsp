<%@ page import="cn.ahpu.springmvc.pojo.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.ahpu.springmvc.pojo.collect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城收藏夹</title>
    <link href="/SprinMvc_Login_war_exploded/css/header.css" rel="stylesheet" />
    <link href="/SprinMvc_Login_war_exploded/css/my.collect.css" rel="stylesheet" />
    <link href="/SprinMvc_Login_war_exploded/css/footer.css" rel="stylesheet" />
</head>
<body>
<!--页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img class="animated jello" src="/SprinMvc_Login_war_exploded/img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a href="" class="rt"><img id="search" src="/SprinMvc_Login_war_exploded/img/header/search.png" alt="搜索"/></a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="index" >首页</a><b>|</b></li>
            <li><a href="collect" >收藏</a><b>|</b></li>
            <li><a href="order" >订单</a><b>|</b></li>
            <li><a href="cart" >购物车</a><b>|</b></li>
            <li><a href="password-change">设置</a><b>|</b></li>
            <li><a href="login">退出</a><b>|</b></li>
            <li><a href="lookforward">帮助</a></li>
        </ul>
    </div>
</header>

<div class="big">
    <form  name="" action="" method="post" >
        <section id="section" >
            <div id="title">
                <b>收藏商品</b>
            </div>


            <div id="box" >
                <%
                    ArrayList<collect> collects = (ArrayList<collect>)request.getAttribute("collect");
                    for(int i=0;i<collects.size();i++){
                        collect collect1 = collects.get(i);
                        if(i%4==0){
                %>
		        <div id="content_box" >
                    <%} %>


                    <div class="lf" id="d1">
                        <div class="img">
                            <a href="/SprinMvc_Login_war_exploded/S.do?isbn=<%=collect1.getProduct()%>">
                            	<img src="/SprinMvc_Login_war_exploded/img/goods/<%=collect1.getProduct()%>/collect.jpg" alt=""/>
                            </a>
                        </div>
                        <div class="describe">
                            <p><%=collect1.getProduct()%></p>
                            <span class="price"><b>￥</b><span class="priceContent">66.2</span></span>
                            <span class="addCart"><a href="/SprinMvc_Login_war_exploded/S.do?isbn=<%=collect1.getProduct()%>">查看</a></span>
                        </div>
                    </div>
                    <%if(i%4==3||i==collects.size()-1){ %>
			    </div>
                <% }%>
                <%} %>
            </div>
        </section>
    </form>
 </div>
<!--品质保障，私人定制等­-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="/SprinMvc_Login_war_exploded/img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="/SprinMvc_Login_war_exploded/img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="/SprinMvc_Login_war_exploded/img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="/SprinMvc_Login_war_exploded/img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!--页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="/SprinMvc_Login_war_exploded/img/footer/tedu.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="/SprinMvc_Login_war_exploded/img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="/SprinMvc_Login_war_exploded/img/footer/wechat.png" alt=""/>
                    <img src="/SprinMvc_Login_war_exploded/img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="/SprinMvc_Login_war_exploded/img/footer/ios.png" class="lf">
            <img src="/SprinMvc_Login_war_exploded/img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="/SprinMvc_Login_war_exploded/img/footer/erweima.png">
        </div>
    </div>
</div>

<script src="/SprinMvc_Login_war_exploded/js/jquery-3.1.1.min.js"></script>
<script src="/SprinMvc_Login_war_exploded/js/collect.js"></script>
<script>
   
</script>
</body>
</html>
