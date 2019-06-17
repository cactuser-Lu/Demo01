<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function post(){
	$.post("/Demo16/DemoServlet02",{name:"zhangsan",age:18},function(data,status){
	    //alert(data);
	    $("#div01").html(data+"01");
	    $("#div01").text(data+"02");
		});
}
function get(){
	//alert("responseText");$
	$.get("/Demo16/DemoServlet02",function(data,status){
    //alert(data);
    $("#div01").html(data+"01");
    $("#div01").text(data+"02");
	});
	
}
</script>
<body>
<input type="button" onclick="get()" value="get方法演示">
<input type="button" onclick="post()" value="post方法演示">
<div id="div01" style="width:100px;height:100px;border:1px solid blue;">
</div>
</body>
</html>