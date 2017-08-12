<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<title>新規登録フォーム</title>
<link rel="stylesheet" href="../css/itemPage.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<hr>
<form:form modelAttribute="userForm" action="${pageContext.request.contextPath }/register">
	<h2>新規登録フォーム</h2>
	
<%--
	<c:if test='${model.containsAttribute("SqlErrorMessage")}'>
	</c:if>
 --%>
	<c:out value="${SqlErrorMessage}"/><br>
<%-- <c:out value="${SqlErrorMessage}"/>登録者が被っている時だけ表示させたい --%>
	
	
	性<br><form:input path="lastName"/><form:errors path="lastName" cssStyle="color:red"/><br>
	名<br><form:input path="firstName"/><form:errors path="firstName" cssStyle="color:red"/><br><br>
	メールアドレス<br><form:input path="email"/><form:errors path="email" cssStyle="color:red"/><br><br>
	パスワード(半角英数16文字以内)<br><form:password path="password"/><form:errors path="password" cssStyle="color:red"/><br>
	パスワード確認<br><form:password path="checkPassword"/><form:errors path="checkPassword" cssStyle="color:red"/><br>
	<c:out value="${PasswordCheckMessage}"/><br><br>
	<input type="submit" value="登録">
</form:form>
<hr>
<jsp:include page="footer.jsp"/>

</body>
</html>