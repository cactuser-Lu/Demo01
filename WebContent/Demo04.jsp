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
function load(){
	$("#text01").load("/Demo16/DemoServlet02",function(responseText,statusTXT,xhr){
		//alert(responseText);
		$("#text01").val(responseText);
	});
}

</script>
<body>
<input type="button" onclick="load()" value="give">
<a href="#" onclick="load()">执行load方法</a>
<input type="text" id="text01">

</body>
</html>