<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎您${user.getUname()}</h1>
${user.getUname()}<br>
${user.getUpwd()}<br>
${user.getPhone()}<br>
<input type="button" onclick="my()" value="dianwo">
${uname}<br>
${upwd}<br>
${get}<br>


</body>
<script>
    function my(){
        alert("欢迎您：")
    }


</script>
</html>
