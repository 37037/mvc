<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>add Emp</title>
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
						<div  style=" text-align:center;height: 50px; background-color:blue;">
							<h1 id="title">
								添加药品
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						add Emp info:
					</h1>
					<form action="save" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									药品名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" id="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									价格:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" id="sal"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									数量:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="job" id="job" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div  style="height: 50px; background-color:blue;">
					123456@126.com
				</div>
			</div>
		</div>

	</body>
</html>
