<%@page import="com.attempt.select.vo.PageVo"%>
<%@page import="Bean.PageBean"%>
<%@page import="Vo.newHvo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <script type="text/javascript">
  function init(){
	  //向右移动的div
 var clientWidth= document.body.clientWidth - 40 +"px"
 var topwidth = document.body.clientWidth +"px"
 console.log("width ",clientWidth)
//上面的div
	 document.getElementById("nextdivv").style.left=clientWidth;
 document.getElementById("topsearch").style.width=topwidth;
 }
  function goright(){
	  if (typeof window.pageYOffset != 'undefined') {
          t = window.pageYOffset;
          l=window.pageXOffset;
          window.scrollTo(l+120,t);
                    }
	  else  if (document.documentElement && document.documentElement.scrollTop) {
	        t = document.documentElement.scrollTop;
	        l = document.documentElement.scrollLeft;
	        window.scrollTo(l+120,t);
	    } else if (document.body) {
	    	 t = document.body.scrollTop;
	   	  l = document.body.scrollLeft;
	   	
	   	  window.scrollTo(l+120,t);
	    }
	  
	  console.log(l)
	  	  console.log(t)
	  
	  //左右移动
  }
  function goleft(){
	  if (typeof window.pageYOffset != 'undefined') {
          t = window.pageYOffset;
          l=window.pageXOffset;
          window.scrollTo(l-120,t);
                    }
	  else	  if (document.documentElement && document.documentElement.scrollTop) {
	        t = document.documentElement.scrollTop;
	        l = document.documentElement.scrollLeft;
	        window.scrollTo(l-120,t);
	    } else if (document.body) {
	    	 t = document.body.scrollTop;
	   	  l = document.body.scrollLeft;
	   	
	   	 window.scrollTo(l-120,t);
	    }
	  
	  
	  
  }
  
  function topdisplay(){
	  var topwidth = document.body.clientWidth +"px"
		if ( document.getElementById("topinside").style.display=="inline")
			{
	  document.getElementById("topsearch").style.width="50px";
	  document.getElementById("topsearch").style.background="none";
	  document.getElementById("topinside").style.display="none";
	  document.getElementById("yincangsrc").style.display="inline";
	  document.getElementById("yincangsrc").style.transform="rotate(0deg)";
	  document.getElementById("topsearch").style.left="15px";
	  document.getElementById("topsearch").style.top="15px";

			}
		else if  ( document.getElementById("topinside").style.display=="none")
		{
			 document.getElementById("topsearch").style.background="rgba(255,255,255,0.6)";
  document.getElementById("topsearch").style.width=topwidth;
  document.getElementById("topinside").style.display="inline";
  document.getElementById("yincangsrc").style.transform="rotate(180deg)";
  document.getElementById("topsearch").style.left="0px";
  document.getElementById("topsearch").style.top="0px";
		}
		
  }
  
 </script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>


<body onload="init()" style=" overFlow-x:hidden;overFlow-y:scroll;height: 837px  ">

<div id="body1" style="height:867px;width:2732px;background: black ;padding-left:50px "   >

<% List<com.attempt.vo.newHvo> ll=null;
int size=0;
PageVo pb=null;
if (request.getAttribute("pageBean")!=null){

	pb = (PageVo)request.getAttribute("pageBean");
	System.out.println("pb now page:"+pb.getPageNum());
	ll=pb.getList();
	if (ll.size()>=30){
		 size = 30;
	}
	else {
		size=ll.size();
	}

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
                                        	  if (top >=837)
                                        	  { top = 837;height=50;  }
                                        	  else{
                                        		  height=837-top+30;
                                        	  }
                                        	  }%>                                 <!-- 调高度 -->                                                                              <!-- 调高度 -->
<div id="div1-b" style="color: yellow; position:absolute;top:<%=top%>px;background: green ;width: 100% ;height: <%=height%>px">

<%=ll.get(i).getSalary() %><br><%=ll.get(i).getWorkYear()%><br><%=ll.get(i).getEducation()%>   </div> 
</div>
<%} %>
<!--  跳转 a href 分页 -->
      <div id="nextpage" style="background: white;height: 837px;width:40px ; float:right; margin-right:1px"> 
<a href="selectcity?page=<%= pb.getPageNum()+1%>">下一页 </a>             
     </div>



</div>

<div id="nextdivv" style="position: fixed;width: 35px;height: 70px;left:0px; top:300px " z-index =100 onclick="goright()"><img src="pi/you.png"style="width: 100%;height: 100%  "  ></div>
<div id="nextdivv" style="position: fixed;width: 35px;height: 70px;left:10px; top:300px" z-index =100 onclick="goleft()"><img src="pi/you.png"style="width: 100%;height: 100% ;transform:rotate(180deg)"></div>

<div id="topsearch" style="display:inline; position: fixed;width: 1000px;height: 100px;left:0px; top:0px;background:rgba(255,255,255,0.6) "  >

        <div id="topinside" style="display:inline; ;width: 100%;height: 100% " z-index =110  ">
        <p style=" float:left">目前仅支持一下城市<br><a href="selectcity?city=北京">北京</a>  <a href="selectcity?city=上海">上海</a> <a href="selectcity?city=深圳">深圳</a> <a href="selectcity?city=杭州">杭州</a> <a href="selectcity?city=大连">大连</a>  <a href="selectcity?city=沈阳">沈阳</a>      </p>
  
        <input type="text" id="sreach" > 
        <a  href="" ><input type="button" value="搜索"></a>
        
        
         <a  href="cleansession" ><input type="button" value="清空筛选"></a>
         </div>
    <a onclick="topdisplay()"  >  <img src="pi/you.png" style="display: inline; width: 30px ;height:  60px ;transform:rotate(180deg)" id="yincangsrc"  ></a>
</div>
</body>
</html>