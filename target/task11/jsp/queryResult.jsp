<%@ page contentType="text/html; charset=shift_jis"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>学生情報管理システム</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  学生情報管理システム Struts2.0版 検索結果画面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">メニュー</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/><br />

<form:form action="query" >
<div style="position:absolute;left:10;height:442;width:981; overflow:auto;">
<table border="0" cellspacing="1" cellpadding="3" bgcolor="#000000">
  <tr align="left">
    <th bgcolor="#A9A9A9">ID</th>
    <th bgcolor="#A9A9A9">名前</th>
    <th bgcolor="#A9A9A9">生年月日</th>
    <th bgcolor="#A9A9A9">住所</th>
  </tr>
      <c:forEach items="${studentList}" var="user">  
      <tr>
    		<td bgcolor="#ffffff">${user.id}&nbsp;</td>
    		<td bgcolor="#ffffff">${user.name}&nbsp;</td>
   			<td bgcolor="#ffffff">${user.birthDate}&nbsp;</td>
    		<td bgcolor="#ffffff">${user.address}&nbsp;</td>
     </tr>
    </c:forEach>  
</table>
</div>
</form:form>
</body>
</html>