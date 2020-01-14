<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/17 0017
  Time: 上午 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
<%@page isELIgnored="false"%>

<head>
    <title>Title</title>
</head>
<body>
<input type="button" id="btn" value="获取数据">
<table  border="1" align="center" width="500px" cellspacing="0" cellpadding="0">
    <tr>

        <td>姓名</td>
        <td>ID</td>
    </tr>
    <tr>

        <td>姓名</td>
        <td>ID</td>
    </tr>

    <tbody id="content">
    
    </tbody>
    
    
    
    
</table>
<script>
   $(function (){
       $("#btn").click(function () {
           $.post("${pageContext.request.contextPath}/ajax/a2",function (data) {
               console.log(data);
               var html="";
               for (var i in data) {
                   html+="<tr>"+
                       "<td>"+ data[i].name+"</td>"+
                       "<td>"+data[i].id+"</td>"+
                       "</tr>"
               }
                $("#content").html(html);
           })
       })
   } ) 
    
   
</script>

</body>
</html>
