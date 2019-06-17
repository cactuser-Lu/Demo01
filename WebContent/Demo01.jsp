<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ajaxFunction() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}

		return xmlHttp;
	}
	function get() {
		var request = ajaxFunction();

		request.open("GET", "/Demo16/DemoServlet01?name=aa&age=18", true);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				alert(request.responseText);
			}
		}
		request.send();
	}
</script>
</head>
<body>
	<h3>
		<a href="" onclick="get()">使用Ajax发送请求</a>
	</h3>

</body>
</html>