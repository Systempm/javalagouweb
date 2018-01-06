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
ResourceBundle res = ResourceBundle.getBundle("a");
HashMap mp = (HashMap)request.getAttribute("hs");
System.out.println(mp);  
%>
<script>
function a(){
document.getElementById("Label11").src="pi/a1.jpg";
document.getElementById("Label11x2").src="pi/a1.jpg";
document.getElementById("Label11x3").src="pi/a1.jpg";
}
function clicka(){
	
	String st	= (String)res.get("label10x1");
         
}
</script>


<body  >

	<table width="100%" border="1" style="table-layout: fixed">
	<tr >
		<td width="4%" align="center">K</td>
        <td width="22%" align="center"> 基本凉了的公司	</td>
	<td width="37%" align="center">基本快要凉了的公司	</td>
	<td width="37%" align="center">热乎的公司	</td>
	</tr>
		<% for  (int i = 1;i<7;i++)  {%>                  
		<tr height="100" >
			<td width="4%" align="center">
			<%=i*10 %>-<%=i*10+10%>K 
			</td>
			<td width="22%">
			<%  
			 
			String	spstr[]= (String[])mp.get("label"+i+"0");
			int num =Integer.parseInt(spstr[0]);
			System.out.println("第:"+ i+"次 num 是"+num);
			
                   for (int j = 0 ; j<num;j++ ){%>          
				<div style="width:40px; float:left;" >
					<img id="Label<%=i %>0x<%=j%>" src="<%=spstr[j+1] %>" width="40px" height="40px" >
				</div> <%			      }%>
				</td>
			<td width="37%" align="center" >
			<% 
			spstr= (String[])mp.get("label"+i+"1");
			num =Integer.parseInt(spstr[0]);
			
			      for (int j = 0 ; j<num;j++ ){%>     
				<div style="width:40px; float:left;" >
				
				<img id="Label<%=i %>1x<%=j%>" src="<%=spstr[j+1] %>" width="40px" height="40px" >
		
				</div> <%			      }%>
			
			</td  >
			<td width="37%" align="center">
			<% 
				spstr= (String[])mp.get("label"+i+"2");
			num =Integer.parseInt(spstr[0]);
			   for (int j = 0 ; j<num;j++ ){ %>   
				<div style="width:40px; float:left;" >
				
				<img id="Label<%=i %>2x<%=j%>" src="<%=spstr[j+1] %>" width="40px" height="40px" >
		
				</div> <%	 }%>
			</td>
		</tr>
		<%} %>

</table>
<a href="clicka()"> aaaaaaaaaaaa </a>
</body>


</html>