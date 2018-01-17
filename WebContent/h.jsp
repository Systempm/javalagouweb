<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body  >
<div style="height:768px;width: 3000px ;background: black">



<%for (int  i  = 0;i <20;i ++){ %>


<%if(i%10==0){%>

	<div style="background: green;height: 700px;width: 70px ;float: left; margin-right:1px; position:relative" >
	<div align="center" style="background: white;height: 40px;width: 70px ; margin-bottom:1px"></div>
	<% for (int j = 0 ;j<20;j++){%>
	<div align="center" style="background: white;height: 40px;width: 70px ; margin-bottom:1px">
	   <%=j*1%>K -<%=(j+1)*1%>K
	</div> 

<%}%>
	</div>
		
<% } %>



<div id="<%= i%>" style="background: white;height: 700px;width: 70px ; float:left; margin-right:1px;position:relative">

<div id ="logo<%= i%>" style="width: 70px; height: 40px " >
<img src="www.lgstatic.com/thumbnail_120x120/image1/M00/00/2D/Cgo8PFTUXHmAQ6K2AAA-xp7F-7c908.jpg"  width="100%" height="100%">
</div>


<div id="div1-b" style="color: yellow; position:absolute;top:160px;background: green ;width: 70px ;height: 90px">

a1</div> 
</div>



<%} %>
</div>
</body>
</html>