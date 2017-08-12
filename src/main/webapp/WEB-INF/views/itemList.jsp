<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset=UTF-8>
<title>商品一覧ページ</title>
<link rel="stylesheet" href="../css/itemPage.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="main">
	<h2>商品一覧ページ</h2>
	<br>

	<c:forEach var="item" items="${itemList }">
	<form action="${pageContext.request.contextPath }/web/to-itemPage">
	<hr>
		<a href="${pageContext.request.contextPath }/web/to-itemPage?itemId=${item.id}">
		<img src="${item.masterPhoto.infoBase64 }"><br>
		</a>		
		<a href="${pageContext.request.contextPath }/web/to-itemPage?itemId=${item.id}">
		<c:out value="商品名　：${item.name }" /><br>
		</a>		
		<c:out value="価格　　：${item.price }" /><br>
		<c:out value="現在庫　：${item.stock }" /><br>
		<input type="hidden" name="itemId" value="${item.id}">
		<input type="submit" value="商品詳細へ">
	</form>
	</c:forEach>
	
</div>
<jsp:include page="sidebar.jsp"/>
<jsp:include page="footer.jsp"/>
</body>
</html>