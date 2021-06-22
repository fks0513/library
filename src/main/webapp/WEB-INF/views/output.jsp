<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 width="500" cellpadding="0">
<caption><h2>더조은 서점 현황</h2></caption>
<tr>
	<th>일련번호</th>
	<th>도서명</th>
	<th>저자</th>
	<th>가격</th>
	<th>표지</th>
	<th>비고</th>
</tr>

<c:forEach items="${list}" var="lib">
<tr>
	<td>${lib.num }</td>
	<td>${lib.book }</td>
	<td>${lib.name }</td>
	<td><fmt:formatNumber value="${lib.price }" pattern="#,###"/></td>
	<td>	         
		<c:forEach var="imageFileName" items="${ map.fileList}"  >
	         <%-- <img src="${pageContext.request.contextPath }/download?imageFileName=${imageFileName }" style="width:150px"> --%>
	         <img src="${pageContext.request.contextPath }/download?imageFileName=${imageFileName }">
	         <br><br><br>
	  </c:forEach>	</td>
	<td>
		<a href="modify?book=${lib.book }">수정</a>&nbsp;
		<a href="delete?book=${lib.book}">삭제</a> 
	</td>
</tr>
</c:forEach>
</table><p>
<a href="input">자료 입력</a>
</body>
</html>