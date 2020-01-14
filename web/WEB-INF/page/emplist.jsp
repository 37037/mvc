<%@ page import="java.util.List" %>
<%@ page import="cn.ahpu.springmvc.pojo.Emp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	</head>
	<body>
		<div id="">
			<div id="top_content">
				<div id="header" >
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div style=" height: 50px; background-color:blue;">
						<h1 id="title" style="text-align: center" >
							            药品库存
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								药品名称
							</td>
							<td>
								价格
							</td>
							<td>
								库存数量
							</td>
							<td>
								Operation
							</td>							
						</tr>
						<% List<Emp> emps= (List<Emp>) request.getAttribute("emp");
							for (Emp emp:emps){


						%>

						<tr class="row1">
							<td>
								<%=emp.getEmpno()%>
							</td>
							<td>
								<%=emp.getName()%>

							</td>
							<td>
								<%=emp.getSal()%>

							</td>
							<td>


							</td>

							<td>
								<a href="${pageContext.request.contextPath}/delete1?empno=<%=emp.getEmpno()%>" >删除药品</a>&nbsp;
								<a id href="${pageContext.request.contextPath}/updateEmp?empno=<%=emp.getEmpno()%>&job=<%=emp.getJob()%>&name=<%=emp.getName()%>&sal=<%=emp.getSal()%>">修改药品信息</a>
							</td>
						</tr>

						<%}%>
					</table>

					<p style="text-align: center">
						<input type="button" class="button" value="添加药品" onclick="location='addEmp'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div style="background-color:blue; height: 50px">

				</div>
			</div>
		</div>
	</body>
<script>

</script>
</html>
