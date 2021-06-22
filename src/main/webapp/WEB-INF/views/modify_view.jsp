<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
   
   border-collapse: collapse;
   background-color: #dae8e8;
}
td,th{
   align : center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="600" cellpadding="10" align="center">
   <tr>
      <td bgcolor="c2c2c2" height="35" align="center">수정할 정보를 입력하세요</td>
   </tr>
</table>
<br><br>
<form action="modifysave" method="post">
<table border=1  align = center  width="350" height="200">
<tr>
<th>책이름</th> <td align = left>&nbsp;<input type="text" value="${book}" name="book"></td>
</tr>

<tr>
<th>수정 가격</th><td align = left>&nbsp;<input type="text" name="price" ></td>
</tr>

</table>
<br>
<center>
<input type="submit" value="입력하기">
<input type="reset" value="취소하기">
</center>
</form>
</body>
</html>