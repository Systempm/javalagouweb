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
HashMap mp = (HashMap)request.getAttribute("hs");
 String json = (String)request.getAttribute("json");
%>
<script type="text/javascript">
console.log("12121");
function showData(){
	
	          var str= '<%=json%>';
	          var jsonParseJson=JSON.parse(str);
	             for (i =1 ;i< <%=(int)mp.get("columnnum")+1%>;i ++)
	            	{
	            	   console.log("i",i)
	            	   for (k = 1 ;k <4;k++)
	            		   {
	            		        var labelname= "label"+i+k;            	
	            		        var nn = "jsonParseJson."+labelname+".num"
	            		         
	            		        
	            		         for( j =0 ;j<parseInt(eval(nn));j++)
	            			     {
	            			       
	            			          var labelnamex="\""+labelname +"x"+ j+"\""; 
	            			          console.log(labelnamex);
	            			          var  strurl=        "jsonParseJson."+labelname+".everyone["+(j)+"].urlpic";      
	       
	            			          var urll = "\""+eval(strurl)+"\"" ;
	            			          
	            			         console.log( "duide", urll);
	            			   
	            			      eval("document.getElementById("+labelnamex+").src="+urll );
	            			      }
	            		   }
	            	 
	            	 
	            	 }
	            	   
	          console.log(jsonParseJson.label11.num);
	             console.log(a);
	    }

function a(){
	
	
document.getElementById("Label").src="pi/a1.jpg";
document.getElementById("Label11x2").src="pi/a1.jpg";
document.getElementById("Label11x3").src="pi/a1.jpg";
}

</script>


<body onload="showData()" >

	<table width="100%" border="1" style="table-layout: fixed">
	<tr >
		<td width="4%" align="center">K</td>
        <td width="22%" align="center"> 基本凉了的公司	</td>
	<td width="37%" align="center">基本快要凉了的公司	</td>
	<td width="37%" align="center">热乎的公司	</td>
	</tr>			
			<% for(int i = 1;i<(int)mp.get("columnnum")+1;i++)  { %>
					<tr height="100" >
			<td width="4%" align="center">
			<%=i*10 %>-<%=i*10+10%>K 
			</td>
	
	<%  
	          for(int k = 1;k <4; k ++){%>

			<td width=" <%	switch (k){case 1:%> <%=22 %><%;case 2 : %><%=37 %><%;case 3 : %><%=37 %><% ;} %>%">
			<%  		
			
                   for (int j = 0 ; j<  (int)mp.get("label"+i+k);j++ ){%>          
				<div style="width:40px; float:left;" >
					<img id="label<%=i %><%=k %>x<%=j%>" src="" width="40px" height="40px" >
				</div> <%			      }%>
				</td>
				<%}} %>
				
				
	

</table>
<a href="clicka()"> aaaaaaaaaaaa </a>
</body>


</html>