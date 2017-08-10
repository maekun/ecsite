<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



新規登録フォーム<br>
<form action="${pageContext.request.contextPath }/register" method="post">
	名：<input type="text" name="firstName"><br>
	性：<input type="text" name="lastName"><br>
	メールアドレス：<input type="email" name="email"><br>
	パスワード：<input type="password" name="password"><br>
	<input type="submit" value="登録">
</form>




</body>
</html>