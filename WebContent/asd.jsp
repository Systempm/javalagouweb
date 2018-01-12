<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">  
#div1 {
position:relative;
}
#div1-a {
position:absolute;
top:70px;
right:0;
width:200px;
}
</style>
</head>

<body>
<div id="div1" style="width: 500px;height: 300px ;background: black;float:left">
   <div id="div1-a" style="color: white;">
    this is div-1a element.
    </div>

</div>
<div style="width: 500px;height: 300px ;background: black ;float:left; position:relative" >
   <div id="div1-b" style="color: white; position:absolute;top:50px;background: green ;width: 70px ;height: 70px">
    this is div-1a element.
    </div>
</div>
</body>
</html>