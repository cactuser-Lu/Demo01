<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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

	function post() {
		var request = ajaxFunction();
		request.open("POST", "/Demo16/DemoServlet01", true);
		request.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				alert(request.responseText);
			}
		}
		request.send("name=obama&&age=22");

	}
</script>

<body>
	<h3>
		<a href="" onclick="post()">使用Ajax发送请求</a>
	</h3>
</body>
</html>