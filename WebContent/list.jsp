<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="width:100%">
<c:forEach items="${list }" var="word">
<tr>
<td>${word.name}</td>
</tr>
</c:forEach>
</table>

</body>
</html>