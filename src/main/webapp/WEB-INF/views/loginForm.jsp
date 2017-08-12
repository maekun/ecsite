<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<title>ログインフォーム</title>
<link rel="stylesheet" href="../css/itemPage.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath }/login" method="post">
	<h2>ログインフォーム</h2>
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