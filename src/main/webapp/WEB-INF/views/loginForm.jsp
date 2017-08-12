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
<hr>
<form:form modelAttribute="userForm" action="${pageContext.request.contextPath }/login">
	<h2>ログインフォーム</h2>
	<c:out value="${LoginErrorMessage}"/>
	<label for="email">メールアドレス</label><br>
	<form:input path="email" id="email"/><form:errors path="email" cssStyle="color:red"/><br><br>
	<c:out value="${PasswordCheckMessage}"/>
	<label for="password">パスワード</label><br>
	<form:password path="password" id="password"/><form:errors path="password" cssStyle="color:red"/><br>
	<label for="checkPassword">パスワード確認</label><br>
	<form:password path="checkPassword" id="checkPassword"/><form:errors path="checkPassword" cssStyle="color:red"/><br><br>
	<input type="submit" value="ログイン">
</form:form>
<hr>
<jsp:include page="footer.jsp"/>
</body>
</html>