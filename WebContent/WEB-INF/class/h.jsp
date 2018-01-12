
<%@page import="Vo.HVo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="height:768px;width: 2000px ;background: black" >
<% List<HVo> ll=null;
if (request.getAttribute("list")!=null){
	 ll = (List<HVo>)request.getAttribute("list");
	}
%>

<div style="background: green;height: 700px;width: 70px ;float: left; margin-right:1px; position:relative">
                                                     <!-- 调高度 -->
<div align="center" style="background: white;height: 40px;width: 70px ; margin-bottom:1px"></div>
<% for (int j = 0 ;j<20;j++){%>
                                                     <!-- 调高度 -->
<div align="center" style="background: white;height: 40px;width: 70px ; margin-bottom:1px">
   <%=j*1%>K -<%=(j+1)*1%>K
</div> 

<%}%>
</div>

<%for (int  i  = 0;i <ll.size();i ++){ %>
                                                           <!--宽度 调高度 -->
<div id="<%= i%>" style="background: white;height: 700px;width: 70px ; float:left; margin-right:1px;position:relative">
                                                   <!-- logo调高度 -->
<div id ="logo<%= i%>" style="width: 70px; height: 40px " >
<img src="<%=ll.get(i).getLogo() %>"  width="100%" height="100%">
</div>
                                                                                        
                                                                           <!-- 调高度 -->                                                                              <!-- 调高度 -->
<div id="div1-b" style="color: yellow; position:absolute;top:<%=ll.get(i).getMinslary()*30%>px;background: green ;width: 70px ;height: <%=ll.get(i).getMaxjianminslary()*30%>px">

a1</div> 
</div>
<%} %>

</body>
</html>