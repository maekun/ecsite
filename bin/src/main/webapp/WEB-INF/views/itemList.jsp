<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE tml>
<html lang="ja">
<head>
<meta charset=UTF-8>
<title>商品一覧ページ</title>

</head>
<body>
<%@ include file="search.jsp" %>
	<%--



			商品検索専用JSP埋め込み位置
			
			
			
--%>
	<h2>商品一覧ページ</h2>
	<br>

	<c:forEach var="item" items="${itemList }">
	<form action="${pageContext.request.contextPath }/to-itemPage">
	<hr>
		<a href="${pageContext.request.contextPath }/to-itemPage?itemId=${item.id}">
		<img src="${item.masterPhoto.infoBase64 }"><br>
		</a>		
		<a href="${pageContext.request.contextPath }/to-itemPage?itemId=${item.id}">
		<c:out value="商品名　：${item.name }" /><br>
		</a>		
		<c:out value="価格　　：${item.price }" /><br>
		<c:out value="現在庫　：${item.stock }" /><br>
		<input type="hidden" name="itemId" value="${item.id}">
		<input type="submit" value="商品詳細へ">
	</form>
	</c:forEach>





</body>
</html>