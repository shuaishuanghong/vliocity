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
  �w�����Ǘ��V�X�e�� SpringMVC+Spring+Mybatis�� ���O�C�����
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">�g�b�v</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>
<div>
<form:form modelAttribute="userModel" action="login" method="POST">
<form:errors path="" element="div"></form:errors>
<table><tr>
    <td width="10"></td>
    <td>���[�U�[ ID: </td>
    
    <td><form:input path="loginname"/><form:errors path="loginname"/></td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>�p�X���[�h: </td>
    <td><form:password path="loginpass" /><form:errors path="loginpass"/></td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <input type="submit" value="   �m�F   "/>
    <input type="reset" value="  �N���A  "/>
    </td> 
</tr></table>
</form:form>
</div>
</body>
</html>