<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


ログインフォーム
<form action="${pageContext.request.contextPath }/login" method="post">
	<label for="email">メールアドレス</label><input type="email" name="email" id="email">
	<label for="password">パスワード</label><input type="password" name="password" id="password">
	<input type="submit" value="ログイン">
</form>

新規登録はこちら
<form action="${pageContext.request.contextPath }/registerForm">
	<input type="submit" value="登録フォームへ">
</form>

</body>
</html>