
<%@page import="Vo.newHvo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 

int screenWidth=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;

%>
  <script type="text/javascript">
  function init(){
 var clientWidth= document.body.clientWidth - 40 +"px"
 console.log("width ",clientWidth)

	 document.getElementById("nextdivv").style.left=clientWidth;
 
 }
  function goright(){
	  t = document.body.scrollTop;
	  l = document.body.scrollLeft;
	
	  window.scrollTo(l+120,t);
	  
	  
  }
  function goleft(){
	  t = document.body.scrollTop;
	  l = document.body.scrollLeft;
	
	  window.scrollTo(l-120,t);
	  
	  
  }
  
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>


<body onload="init()" style=" overFlow-x:hidden;overFlow-y:scroll;height: 837px">

<div id="body1" style="height:837px;width:<%=screenWidth*2%>px;background: black "  >

<% List<newHvo> ll=null;
int size;
if (request.getAttribute("list")!=null){
	 ll = (List<newHvo>)request.getAttribute("list");
	}
if (ll.size()>=30){
	 size = 30;
}
else {
	size=ll.size();
}

%>



<%for (int  i  = 0;i <size;i ++){ %>


<%if(i%14==0){%>

	<div style="background: green;height: 837px;width: 80px ;float: left; margin-right:1px; position:relative" id = "divwidth" >
	<div align="center" style="background: white;height: 61px;width: 100% ; margin-bottom:1px"></div>
	<% for (int j = 0 ;j<25;j++){%>
	<div align="center" style="background: white;height: 30px;width: 100% ; margin-bottom:1px">
	   <%=j*1%>K -<%=(j+1)*1%>K
	</div> 
   
<%}%>
 <div align="center" style="background: white;height: 30px;width: 100% ; margin-bottom:1px">
	   +++
	</div> 
	</div>
		
<% } %>




                                                           <!--宽度 调高度 -->
<div id="<%=i %>" style="background: white;height: 837px;width: 80px ; float:left; margin-right:1px;position:relative">
                                                   <!-- logo调高度 -->
<div id ="logo<%= i%>" style="width: 100%; height: 61px " >
<img src="<%=ll.get(i).getCompanyLogo() %>"  width="100%" height="100%">
</div>
    <p style="Writing-mode:tb-rl">    <%=ll.get(i).getPositionName() %>  <br> <%=ll.get(i).getCompanshortname() %></p>            
    
                      
                                                                                        
                                          <% int top = ll.get(i).getMinsalary()*31+62;
                                         int  height=ll.get(i).getMaxjianminslary()*31;
                                          if(top + height>837)
                                        	  {
                                        	  if (top >837)
                                        	  { top = 820;height=17;  }
                                        	  else{
                                        		  height=837-top;
                                        	  }
                                        	  }%>                                 <!-- 调高度 -->                                                                              <!-- 调高度 -->
<div id="div1-b" style="color: yellow; position:absolute;top:<%=top%>px;background: green ;width: 100% ;height: <%=height%>px">

<%=ll.get(i).getSalary() %><br><%=ll.get(i).getWorkYear()%><br><%=ll.get(i).getEducation()%>   </div> 
</div>
<%} %>
</div>

<div id="nextdivv" style="position: fixed;width: 50px;height: 50px;left:0px; top:300px;background: pink " z-index =100 onclick="goright()">right</div>
<div id="nextdivv" style="position: fixed;width: 50px;height: 50px;left:10px; top:300px;background: pink " z-index =100 onclick="goleft()">left</div>
</body>
</html>