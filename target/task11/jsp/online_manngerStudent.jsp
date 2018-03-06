<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="./css/demo.css">
    <script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="./js/manger.js"></script>
</head>
<body>
    <div id="main">
        <div id="head"><h3>学生管理</h3></div>
        <div id="body">

                <div id="left">
                    <div style="width: 100%">                      
                        <select id="select1"  style="width: 100%;height: 30px">
                       		<option value="-1" >请选择班级...</option>
         					<c:forEach items="${classIdList}" var="ids">           						
								<c:choose>   
     							<c:when test="${ids eq id}">  
        							<option selected="selected" value="${ids}">${ids}班</option>  
     							</c:when>  
     							<c:otherwise>  
        							<option  value="${ids}">${ids}班</option>  
     							</c:otherwise>  
      							</c:choose>	
								<%-- <option  value="${ids}">${ids}班</option> --%>		
  		 				 	</c:forEach>
       				 </select>
                    </div>
                    <div style="width: 100%" id="chstu">
                    <select id="select2" multiple="multiple" style="width:100%;height:420px">
          				<c:forEach items="${studentList}" var="student">  
   				 			<option value="${student.id}">${student.id}:${student.name}</option>
      					</c:forEach> 
       			 	</select>        					
                    </div>
                </div>
                <div id="center">
                    <div class="buttondiv"><button id="right_btn" onclick="right_move()">==》</button></div>
                    <div class="buttondiv"><button id="left_btn" onclick="left_move()">《==</button></div>
                </div>
                <div id="right">
                	<div style="width: 100%;height: 30px;border: solid #444455 0.5px;text-align: center;">
                	全ての学生を表示する
                	</div>
                    <div style="background-color: #c0c0c0;height:420px" id="otherList">
                    <select id="select3" multiple="multiple" style="width:100%;height:420px">
          				<c:forEach items="${allstudentList}" var="student">  
   						 	<option value="${student.id}">${student.id}:${student.name}</option>
     				 	</c:forEach>
        			</select>       				
                    </div>
                </div>

        </div>
        <form id="changerClassID" action="change_student_byclassId" method="post" style="display:none;">
        	<input type="text" name="cur_classid" value="">
        	<input type="text" name="stu_id_remove" value="">
        	<input type="text" name="stu_id_add" value="">
        	<input type="submit">
        </form>
        <form  id="Secondform" action="second_students" method="post" style="display:none;">
        	<input type="text" name="adid" value="">
        	<input type="submit">
        </form>
        <div id="bootom" style="margin-left: 60%;padding-top: 20px"><button onclick="changeStu()" >确定</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="cancel()">取消</button></div>
    </div>
</body>
</html>