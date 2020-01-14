<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title>达内商城学子注册页面</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/login.css" rel="stylesheet" />
</head>
<body>
<!--模态框-->
<div class="modal">
  	<div class="modal_header">
    	提示信息
  	</div>
  	<div class="modal_content">
    	恭喜您已成功注册达内学子商城！
  	</div>
</div>
<!-- 页面顶部-->
<header id="top">
  <div class="top">
    <img src="../img/header/logo.png" alt=""/>
    <span>欢迎注册</span>
    
    <iframe width="420" scrolling="no" height="60" frameborder="0" allowtransparency="true" src="//i.tianqi.com/index.php?c=code&id=12&icon=1&num=5&site=12"></iframe>
    
    <span style="color:green;margin-top:15px;margin-left:380px" id="clock"></span>
  </div>
</header>
<div class="parent">
  <div class="container">
    <div class="panel rt">
      <form id="fm-register" method="post" action="UserRegistServlet">
        <div class="txt">
          <p id="newuser">新用户注册
            <span>
              <a href="login.html" id="dlogin">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="uname">用户名&nbsp;：</label>
          <input onblur="check_onblur_uname();" onclick="check_onclick_uname();" autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus name="uname" id="uname"/>
          <span></span>
        </div>
        <div class="form-group">
          <label for="upwd">密&nbsp;&nbsp;&nbsp;码：</label>
          <input onblur="check_onblur_upwd();" onclick="check_onclick_upwd();" required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="upwd" autofocus id="upwd"/>
          <span></span>
        </div>
        <div class="form-group">
          <label for="email">邮&nbsp;&nbsp;&nbsp;箱：</label>
          <input autocomplete required type="email" placeholder="请输入邮箱地址" name="email" id="email"/>
          <span></span>
        </div>
        <div class="form-group">
          <label for="phone">手&nbsp;&nbsp;&nbsp;机：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" pattern="^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$" required type="text" />
          <span></span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register"/>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
  <div class="icon1 lf">
    <img src="../img/footer/icon1.png" alt=""/>

    <h3>品质保障</h3>
  </div>
  <div class="icon2 lf">
    <img src="../img/footer/icon2.png" alt=""/>

    <h3>私人定制</h3>
  </div>
  <div class="icon3 lf">
    <img src="../img/footer/icon3.png" alt=""/>

    <h3>学员特供</h3>
  </div>
  <div class="icon4 lf">
    <img src="../img/footer/icon4.png" alt=""/>

    <h3>专属特权</h3>
  </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
  <div id="foot">
    <div class="lf">
      <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
      <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
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
          <img src="../img/footer/wechat.png" alt=""/>
          <img src="../img/footer/sinablog.png" alt=""/>
        </li>
      </ul>
    </div>
    <div class="service">
      <p>达内商城客户端</p>
      <img src="../img/footer/ios.png" class="lf">
      <img src="../img/footer/android.png" alt="" class="lf"/>
    </div>
    <div class="download">
      <img src="../img/footer/erweima.png">
    </div>
  </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
 var t=null;//当前时间
 function start(){// 自定义函数：启动时间
	t=setInterval(function(){
		var nowTime = new Date();
		var time = nowTime.toLocaleTimeString();
		var c = document.getElementById("clock");
		c.innerHTML="系统时间："+time;
	},1000);//定时器函数，两个参数，1、自定义函数，2、毫秒
 }
start();
//www.tianqi.com/plugin
 
 //获取焦点时的提示
 function check_onclick_uname(){
	 //获取当前文本框的节点
	 var uname=document.getElementById("uname");
	 //当前节点的下一个节点
	 uname.nextElementSibling.innerHTML="用户名长度在6~9之间";
	 uname.nextElementSibling.className="msg-default";	
 }
 
 //失去焦点时的提示
 function check_onblur_uname(){
	 //1.非空验证
	 var uname=document.getElementById("uname");
	 var value=uname.value;
	 if(value.length==0){
		 uname.nextElementSibling.innerHTML="用户名不能为空";
		 uname.nextElementSibling.className="msg-error";
	 }
	 //2.格式错误的提示
	 else if(value.length<6 || value.length>9){
		 uname.nextElementSibling.innerHTML="用户名长度在6~9之间";
		 uname.nextElementSibling.className="msg-error";
	 }
	 //3.格式正确的提示
	 else{
		 uname.nextElementSibling.innerHTML="用户名格式正确";
		 uname.nextElementSibling.className="msg-success";
	 }
	//用户名ajax验证
	var xhr = getXhr();
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var data = xhr.responseText;//服务器返回的数据
			if(data=="no"){//姓名被占用
				uname.nextElementSibling.innerHTML="用户名已经被占用";
				uname.nextElementSibling.className="msg-error";
			}else{//姓名可以使用
				uname.nextElementSibling.innerHTML="用户名格式正确";
				uname.nextElementSibling.className="msg-success";
			}
		}
	};
	xhr.open("get","CheckUnameServlet?uname="+value,true);
	xhr.send(null);
	
 }
 //密码框点击时的提示
 function check_onclick_upwd(){
	//获取当前文本框的节点
	 var uname=document.getElementById("upwd");
	 //当前节点的下一个节点
	 uname.nextElementSibling.innerHTML="密码长度在6~12之间";
	 uname.nextElementSibling.className="msg-default";	
	 
 }
//密码框失去焦点时的提示
 function check_onblur_upwd(){
	 
	//1.非空验证
	 var uname=document.getElementById("upwd");
	 var value=uname.value;
	 if(value.length==0){
		 uname.nextElementSibling.innerHTML="密码不能为空";
		 uname.nextElementSibling.className="msg-error";
	 }
	//2.格式错误的提示6~12位之间
	 else if(value.length<6 || value.length>12){
		 uname.nextElementSibling.innerHTML="用户名长度在6~12之间";
		 uname.nextElementSibling.className="msg-error";
	 }
	//3.格式正确的提示
	else{
		 uname.nextElementSibling.innerHTML="用户名格式正确";
		 uname.nextElementSibling.className="msg-success";
	 }	 
 }
//邮箱框点击(获取焦点)时的提示
$("#email").focus(function(){
	this.nextElementSibling.innerHTML="请输入正确的邮箱";
	this.nextElementSibling.className="msg-default";
});
//邮箱框失去焦点时的提示
$("#email").blur(function(){
	var regex = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
	//1.非空验证 
	if(this.validity.valueMissing){
		this.nextElementSibling.innerHTML="邮箱不能为空";
		this.nextElementSibling.className="msg-error";
	}	
	//2.邮箱格式正确的验证
	else if(regex.test(this.value)){
		this.nextElementSibling.innerHTML="邮箱格式正确";
		this.nextElementSibling.className="msg-success";
	}
	//3.邮箱不正确的提示
	else{
		this.nextElementSibling.innerHTML="邮箱格式不正确";
		this.nextElementSibling.className="msg-error";
	}
	//格式不正确，HTML5：this.validity.typeMismatch
	
	 //emailajax验证
	 
});
//手机框点击(获取焦点)时的提示(请输入合法手机号)
$("#phone").focus(function(){
	this.nextElementSibling.innerHTML="请输入正确的手机号";
	this.nextElementSibling.className="msg-default";
});
//邮箱框失去焦点时的提示	 
$("#phone").blur(function(){
	//1.非空验证(手机号不能为空)
	if(this.validity.valueMissing){
		this.nextElementSibling.innerHTML="手机号不能为空";
		this.nextElementSibling.className="msg-error";
	}	
	//2.格式错误的验证(手机格式不正确),JQuery validity插件为表单提供了强大的验证功能
	//让客户端验证变得更简单，同事提供了大量的定制选项，满足应用程序的各种需求，该
	//插件提供了一套有用的验证方法，包括URL，电子邮箱，手机号等，还提供用户编写
	//自定义的验证方法的API
	else if(this.validity.patternMismatch){
		this.nextElementSibling.innerHTML="手机号格式不正确";
		this.nextElementSibling.className="msg-error";
	}
	//3.格式正确(手机格式正确)
	else{
		this.nextElementSibling.innerHTML="手机号格式正确";
		this.nextElementSibling.className="msg-success";
	}
	//phoneajax验证	 
});
//点击提交按钮
$("#bt-register").click(function(){
	var length=0;
	//遍历id为form-group的所有标签
	$(".form-group").each(function(){
		if($(this).find("span").hasClass("msg-success")){
			length++;
		}
	});
	// 表单提交
	if(length==4){
		$("#fm-register").submit();
	}
});

function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest()
	}else{
		xhr = new ActiveXObject("Microsoft XMLHttpRequest");
	}
	return xhr;
}
</script>
</body>
</html>
