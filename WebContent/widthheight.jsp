<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>获取当前对象大小以及屏幕分辨率等</title>
<body>
<div style=" width:88%;margin:30px auto; color:blue;" id="div_html">
</div>
<script type="text/javascript">
var s = ""; 
s += " 网页可见区域宽："+ document.body.clientWidth+"<br />"; 
s += " 网页可见区域高："+ document.body.clientHeight+"<br />"; 
s += " 网页可见区域宽："+ document.body.offsetWidth + " (包括边线和滚动条的宽)"+"<br />"; 
s += " 网页可见区域高："+ document.body.offsetHeight + " (包括边线的宽)"+"<br />"; 
s += " 网页正文全文宽："+ document.body.scrollWidth+"<br />"; 
s += " 网页正文全文高："+ document.body.scrollHeight+"<br />"; 
s += " 网页被卷去的高(ff)："+ document.body.scrollTop+"<br />"; 
s += " 网页被卷去的高(ie)："+ document.documentElement.scrollTop+"<br />"; 
s += " 网页被卷去的左："+ document.body.scrollLeft+"<br />"; 
s += " 网页正文部分上："+ window.screenTop+"<br />"; 
s += " 网页正文部分左："+ window.screenLeft+"<br />"; 
s += " 屏幕分辨率的高："+ window.screen.height+"<br />"; 
s += " 屏幕分辨率的宽："+ window.screen.width+"<br />"; 
s += " 屏幕可用工作区高度："+ window.screen.availHeight+"<br />"; 
s += " 屏幕可用工作区宽度："+ window.screen.availWidth+"<br />"; 
s += " 你的屏幕设置是 "+ window.screen.colorDepth +" 位彩色"+"<br />"; 
s += " 你的屏幕设置 "+ window.screen.deviceXDPI +" 像素/英寸"+"<br />"; 

document.getElementById("div_html").innerHTML = s;
</script>
</body>
</html>