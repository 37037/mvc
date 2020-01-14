<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17 0017
  Time: 下午 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>

<head>
    <title>Title</title>
</head>
<body>
<p>
    用户名：
    <input type="text" id="name" onblur="a4()">
    <span id="nameInfo"></span>

</p>
<p>
    密码：
    <input type="text" id="pwd">
</p>
<script>
    function a4() {
        $.post(
            "${pageContext.request.contextPath}/ajax/a3",
            {"name":$("#name").val()},
            function (data) {
                if(data.toString()=="ok"){
                    $("#nameInfo").css("color","green");
                }else {
                    $("#nameInfo").css("color","red");

                }
                $("#nameInfo").html(data);
            }


        )
    }


</script>
</body>
</html>
