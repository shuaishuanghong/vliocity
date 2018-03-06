$(function(){
	  /*$("#select1").bind("change",function(){  
		  var id=$(this).val();
		  $.ajax({
              timeout: 3000,
              async: false,
              type: "POST",
              data:{classid:id},
              url: "query_student_byclassId",
              dataType: "json",
              success: function (data) {
                  var StudentList = data["data"];    
              }
          });
        }) */ 
        $("#select1").bind("change",function(){  
	  		  var id=$(this).val();	 
		  	  $("#Secondform input[name=adid]").val(id);
		  	  $("#Secondform").submit();
          })  
});

function changeStu(){
	 $("#changerClassID").submit();
}

function cancel(){
	var cur_classid;
	$("#select1 option:selected").each(function() { 
		  cur_classid=$(this).val();			 
	});
	 $("#Secondform input[name=adid]").val(cur_classid);
 	  $("#Secondform").submit();
}
function right_move() { 
	/*var str = "";
	$("input[name='currstudents']").each(function(){    
        if($(this).is(":checked"))    
        {    
            var	str1 = $(this).val();  
            var str2=  $("input:checkbox[name='currstudents']:checked").next().text();
            
            $(this).remove();
            $("#chstu").find('span:eq(0)').remove();            
            $("#otherList").append("<input type='checkbox' name='"+str1+"'>"+str2+"<br>");           
        }    
    });    */
		var cur_classid;
		$("#select1 option:selected").each(function() { 
			  cur_classid=$(this).val();			 
		});
		var stu_id_remove=new Array();
		$("#select2 option:selected").each(function() { 
			  var str=$(this).val();
			  stu_id_remove.push($(this).val());
		});
		$("#changerClassID input[name=stu_id_remove]").val(stu_id_remove);
		$("#changerClassID input[name=cur_classid]").val(cur_classid);
        var $option = $("#select2 option:selected");  //获取选中的选项
        $option.appendTo("#select3");  //追加给对方    
}
function left_move() {
	    var cur_classid;
		$("#select1 option:selected").each(function() { 
			  cur_classid=$(this).val();			 
		});
		var stu_id_add=new Array();
		$("#select3 option:selected").each(function() { 
		  var str=$(this).val();
		  stu_id_add.push($(this).val());
		});
		$("#changerClassID input[name=stu_id_add]").val(stu_id_add);
		$("#changerClassID input[name=cur_classid]").val(cur_classid);
		var $option = $("#select3 option:selected");
		$option.appendTo("#select2");
}

