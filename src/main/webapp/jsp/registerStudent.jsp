<%@ page contentType="text/html; charset=shift_jis"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=shift_jis"/>
  <meta http-equiv="Content-Script-Type" content="text/javascript"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task.css" type="text/css"/>
  <title>�w�����Ǘ��V�X�e��</title>
</head>

<body>
<div style="font-weight:700;font-size:16px">
  �w�����Ǘ��V�X�e�� Struts2.0�� �o�^���
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">���j���[</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>

<form action="register" method="post">
  <label>ID     </label><input name="id" type="text"/><br>
  <label>���O       </label><input name="name" type="text"/><br>
  <label>���N����</label> <input name="birthDate" type="text"/><br>
  <label>�Z��        </label> <input name="address" type="text"/><br>
  <input type="submit" value="   �m�F   "/>
  <input type="reset" value="  �N���A  "/>
</form>
</body>
</html>