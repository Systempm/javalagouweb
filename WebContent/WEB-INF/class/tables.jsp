<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ResourceBundle, java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
int [][]list = {{4,5,6},{4,5,6},{4,5,6}};
HashMap mp = (HashMap)request.getAttribute("list");
System.out.println("sb");
ResourceBundle res = ResourceBundle.getBundle("a"); %>
<script>
function a(){
document.getElementById("Label11").src="pi/a1.jpg";
document.getElementById("Label11x2").src="pi/a1.jpg";
document.getElementById("Label11x3").src="pi/a1.jpg";
}
</script>


<body onload=a()>

	<table width="100%" border="1" style="table-layout: fixed">
	<tr >
        <td> 基本凉了的公司	</td>
	<td>基本快要凉了的公司	</td>
	<td>热乎的公司	</td>
	</tr>
		<% for  (int i = 1;i<7;i++)  {%>
		<tr height="100">
			<td width="24%"><%=i*10 %>-<%=i*10+10%>K <%  
  for (int j = 0 ; j<list[0][0];j++ ){%>
				<div>
					<img id="Label<%=i %>1x<%=j%>" scr="" width="40px" height="40px" >
				</div> <% }%></td>
			<td width="38%">
				<div>
					<img id="Label<%=i %>1" scr="">
				</div> 123
			</td>
			<td width="38%">
				<div>
					<img id="Label<%=i %>1" scr="">
				</div> 1515
			</td>
		</tr>
		<%} %>


		<input type="button" onclick="a()" value="Change image">
		<img src="<%=res.getString("a1")%>">
</body>


</html>