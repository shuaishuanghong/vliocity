<%@ page contentType="text/html; charset=shift_jis"%>

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
  �w�����Ǘ��V�X�e�� SpringMVC+Spring+Mybatis�� �����[���j���[���
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">�g�b�v</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>
<table><tr>
    <td width="10"></td>
    <td>1.<a href="<%=request.getContextPath()%>/menu?actionType=register">�w�����V�K�o�^ (*)</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>2.<a href="<%=request.getContextPath()%>/menu?actionType=query">�w����񌟍�(*)</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>3.<a href="<%=request.getContextPath()%>/menu?actionType=delete">�w�����폜</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>4.<a href="<%=request.getContextPath()%>/menu?actionType=update">�w�����X�V</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>5.<a href="<%=request.getContextPath()%>/init_students">�w���I�����C���Ǘ�</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>6.<a href="#" onclick="window.close()">���� (*)</a> </td>
  </tr><tr>
</tr></table>
</body>
</html>
