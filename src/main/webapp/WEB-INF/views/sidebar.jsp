<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="sidebar">

	<div class="search-form">
		<form action="${pageContext.request.contextPath }/web/word-search">
		商品名：<br><input type="text" name="inputWord">
		<input type="submit" value="検索"><br>
		</form>
	</div>
	<div class="search-form">
		<form action="${pageContext.request.contextPath }/web/number-of-players-search">
		プレイ人数：<br><input type="number" name="numberOfPlayers">人
		<input type="submit" value="検索"><br>
		</form>
	</div>
	<div class="search-form">
		<form action="${pageContext.request.contextPath }/web/play-time-search">
		プレイ時間：<br><input type="number" name="playTime">分
		<input type="submit" value="検索"><br>
		</form>
	</div>
	<div class="search-form">
		<form action="${pageContext.request.contextPath }/web/price-search">
		お値段：<br><input type="number" name="price">円以下
		<input type="submit" value="検索"><br>
		</form>
	</div>
	<div class="cart">
		<c:out value="${user.lastName} さんのカート"/>
	</div>
</div>

