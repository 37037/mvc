<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div   style=" text-align:center;height: 50px; background-color:blue;">
							<h1 id="title">
								修改信息
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="update?empno=<%=request.getParameter("empno")%>" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									<%=request.getParameter("empno")%>
									<input type="hidden" name="id" id="id"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" id="name"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" id="sal"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									job:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="job"id="job"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
						</p>
					</form>
				</div>
			</div>
			<div   style="height: 50px; background-color:blue;">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
		<script src="../SprinMvc_Login_war_exploded/js/jquery-3.1.1.min.js"></script>

		<script>
			$(function () {
				var name ='<%=request.getParameter("name")%>';
				var sal ='<%=request.getParameter("sal")%>';
				var job1 ='<%=request.getParameter("job")%>';
				var id ='<%=request.getParameter("empno")%>';


					$("#name").val(name);


					$("#sal").val(sal)

					$("#job").val(job1);
					$("#id").val(id);


			});
		</script>
	</body>
</html>
