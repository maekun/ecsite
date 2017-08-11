<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form action="${pageContext.request.contextPath }/web/word-search">
商品名：<br><input type="text" name="inputWord"><br>
<input type="submit" value="検索"><br>
</form>
ーーーここから下未完成ーーー
action/type/name全て未設定
<form action="${pageContext.request.contextPath }/web/word-search">
プレイ人数：<br><input type="text" name="inputWord">人<br>
<input type="submit" value="検索"><br>
</form>
<form action="${pageContext.request.contextPath }/web/word-search">
プレイ時間：<br><input type="text" name="inputWord">分<br>
<input type="submit" value="検索"><br>
</form>
<form action="${pageContext.request.contextPath }/web/word-search">
お値段：<br><input type="text" name="inputWord">円<br>
<input type="submit" value="検索"><br>
</form>
