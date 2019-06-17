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

	function checkName() {
		var name = document.getElementById("name").value;
		var request = ajaxFunction();
		request.open("POST", "/Demo16/checkNameServlet", true);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var data = request.responseText;
				if (data == '1') {
					//alert("用户名已存在!");
                    document.getElementById("span01").innerHTML="<font color='red'>用户名已存在!</font>";
				} else {
					//alert("用户名未存在!");
					document.getElementById("span01").innerHTML="<font color='green'>用户名可用</font>";
				}

			}
		}

		request.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		request.send("name=" + name);
	}
	
	function checkNameJs(){
		var name=$("#name").val();
		$.post("/Demo16/checkNameServlet",{name:name},function(data,status){
			if(data=='1'){
				$("#span01").html("<font color='red'>不可用</font>");
				//alert("不可用");
			}else{
			$("#span01").html("<font color='green'>可用</font>");
				//alert("可用");
			}
		});
	}
</script>
<body>
	<table border="1" width="500">
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="name" id="name"
				onblur="checkNameJs()">
			<span id="span01"></span></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td>简介</td>
			<td><input type="text" name=""></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册"></td>

		</tr>
	</table>
</body>
</html>