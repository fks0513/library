<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1><더조은 서점 도서 입력></h1>
<table border="1" style="width:400; height:100">
<form action="write" method="get" enctype="multipart/form-data">
<tr><td>도서명</td><td><input type="text" name="book"></td></tr>
<tr><td>저자</td><td><input type="text" name="name"></td></tr>
<tr><td>일련번호</td><td><input type="text" name="num" value="ISBN-"></td></tr>
<tr><td>가격</td><td><input type="text" name="price"></td></tr>
<!--  <tr><td width="100">표지</td><td><input type="file" name="file"></td></tr>-->
<tr>
<td colspan="2"><input type="submit" value="입력">&emsp;<input type="reset" value="취소"></td>
</tr>
</table><p>


</form>
</center>
</body>
</html>