<%@ page contentType="text/html; charset=shift_jis"%>

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
  学生情報管理システム SpringMVC+Spring+Mybatis版 メンーメニュー画面
  <span style="position:absolute;right:25px">
    <a href="<%=request.getContextPath()%>/menu">トップ</a>
  </span>
</div>
<hr size="1" style="border:thin dashed #008080"/>
<table><tr>
    <td width="10"></td>
    <td>1.<a href="<%=request.getContextPath()%>/menu?actionType=register">学生情報新規登録 (*)</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>2.<a href="<%=request.getContextPath()%>/menu?actionType=query">学生情報検索(*)</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>3.<a href="<%=request.getContextPath()%>/menu?actionType=delete">学生情報削除</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>4.<a href="<%=request.getContextPath()%>/menu?actionType=update">学生情報更新</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>5.<a href="<%=request.getContextPath()%>/init_students">学生オンライン管理</a> </td>
  </tr><tr>
    <td>&nbsp;</td>
    <td>6.<a href="#" onclick="window.close()">閉じる (*)</a> </td>
  </tr><tr>
</tr></table>
</body>
</html>
