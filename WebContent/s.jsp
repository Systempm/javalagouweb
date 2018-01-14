<%@page import="java.io.BufferedReader"%>  
<%@page import="java.io.FileReader"%>  
<%@page import="java.io.File"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="Utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<%  

        //String filePath = request.getSession().getServletContext().getRealPath("/")+"JSP_Ajax"+"\\";  
        //System.out.println("filePath=="+filePath);  
        String path ="D:\\";   // 这边文件目录需改成相对路径  
        File file = new File(path,"lagou.json");  
        FileReader fr = new FileReader(file);  //字符输入流  
        BufferedReader br = new BufferedReader(fr);  //使文件可按行读取并具有缓冲功能  
        StringBuffer strB = new StringBuffer();   //strB用来存储jsp.txt文件里的内容  
        String str = br.readLine();  
        while(str!=null){  
            strB.append(str);   //将读取的内容放入strB  
            str = br.readLine();  
        }  
        
        String a= strB.toString();
       // System.out.println(a);
        br.close();    //关闭输入流  
        //System.out.println(strB);
    %>  
    
  <script language="javascript">
    function ff1()
    {
        var flag =  parent.document.getElementById('mainframe').getAttribute('flag');
        if(flag == 'true')
            window.frameElement.parentNode.setAttribute('this',document.body.scrollTop);
        else
            scrollTo(0,window.frameElement.parentNode.getAttribute('this'));
        setTimeout("ff1()",1);
    }
    ff1();
</script>
    <script type="text/javascript">
    var a= '<%=a%>';
    var b=6;
    document.getElementById('show').innerHTML = b;
    
    document.getElementById('show1').innerHTML = b;
      function showData1(){
    	  var str3='{"GetUserPostByIdResult":{"Age":"33","ID":"2server","Name":"mady"}}';
    	    var obj3 = eval('('  +str3 + ')'); 
    	    alert( obj3.GetUserPostByIdResult.ID);
    }

      
    function showData(){

             var str='<%=strB%>';
             var jsonParseJson=JSON.parse(str);
             console.log(jsonParseJson.label11.num);
             console.log(jsonParseJson.label12.num);
             console.log(jsonParseJson.label13.num);
    }
    
    
    
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="Button1" type="button" value="date1" onclick="showData1()" /> 
<input id="Button1" type="button" value="Hit Me" onclick="showData()" /> 
<textarea name="eduhistory" cols="50" rows="10" align="center"><%=strB%></textarea>
 
<img  src="pi/a1.jpg">
<a href="chuanzhi" ><img  src="pi/a1.jpg"> </a>


<pre id="show"> </pre>
-------------------------------- Get()

<p id="show1"></p>
</body>
</html>