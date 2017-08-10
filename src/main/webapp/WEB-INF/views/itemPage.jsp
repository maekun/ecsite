<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<title><c:out value="${item.name}詳細ページ"/></title>
</head>
<body>

<%@ include file="header.jsp" %>
<%--



			商品検索専用JSP埋め込み位置
			
			
			
--%>

<h1><c:out value="${item.name}"></c:out></h1>

<img src="${item.masterPhoto.infoBase64}">
<c:forEach var="photo" items="${item.photoList}">
	<img src="${photo.infoBase64}">
</c:forEach><br>

<hr>
<h2><c:out value="${item.infoTitle}"/></h2>
<pre><c:out value="${item.info}"/></pre>



<form action="${pageContext.request.contextPath }/web/index">
	<input type="submit" value="商品一覧に戻る">
</form>

</body>
</html>