/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;

/**
 * 検索アクションクラス
 * 
 * @author Realsys
 */
@Controller
public class QueryAction{
	private static final String INPUT="error";
	private static final String SUCCESS="queryResult";
	
	@Autowired
	private StudentService service;
	@RequestMapping(value={"/query"})
	public String executeAction(@Param("name") String name,Model  model) throws Exception{
		String result = SUCCESS;
		try {
			List<StudentModel> studentList = service.doQueryStduentList(name);
			if (studentList.size() < 1) {
				//addActionError(this.getText("I004"));
				return INPUT;
			}
			model.addAttribute("studentList", studentList);
		} catch (TaskException e) {
			throw e;
		}
		
		return result;
	}
	/*@RequestMapping(value={"/query_class_id"})
	public String executeAction2(Model  model) throws Exception{
		String result = SUCCESS;
		try {
			List<Integer> classIdList = service.getQueryStudent_class_id();
			if (classIdList.size() < 1) {
				//addActionError(this.getText("I004"));
				return INPUT;
			}
			model.addAttribute("classIdList", classIdList);
		} catch (TaskException e) {
			throw e;
		}
		return null;
	}
	@RequestMapping(value={"/query_all_student"})
	public String executeAction3(Model  model) throws Exception{
		String result = SUCCESS;
		try {
			List<StudentModel> studentList = service.getQueryALlStudent();
			if (studentList.size() < 1) {
				//addActionError(this.getText("I004"));
				return INPUT;
			}
			model.addAttribute("allstudentList", studentList);
		} catch (TaskException e) {
			throw e;
		}
		
		return result;
	}*/
	@RequestMapping(value={"/init_students"})
	public String initStudents(Model model) throws Exception{
		try {
			List<StudentModel> studentList = service.getQueryALlStudent();
			if (studentList.size() < 1) {
				//addActionError(this.getText("I004"));
				return INPUT;
			}
			List<Integer> classIdList = service.getQueryStudent_class_id();
			if(classIdList.contains(-1)){
				classIdList.remove(new Integer(-1));
			}
			if (classIdList.size() < 1) {
				//addActionError(this.getText("I004"));
				return INPUT;
			}
			model.addAttribute("id", 0);
			model.addAttribute("classIdList", classIdList);
			model.addAttribute("allstudentList", studentList);		
		} catch (TaskException e) {
			throw e;
		}
		return "online_manngerStudent";		
	}
	@RequestMapping(value={"/second_students"},method = RequestMethod.POST)
	public String secondform(String adid,Model model) throws Exception {
		if(adid.equals("-1")){
			return "redirect:init_students";
		}
		try {
			List<StudentModel> studentList = service.getStudentByclass_id(Integer.valueOf(adid));
			if (studentList.size() < 1) {
				return INPUT;
			}
			List<StudentModel> otherstudentList = service.getQueryotherALlStudent(adid);
			if (studentList.size() < 1) {
				return INPUT;
			}
			List<Integer> classIdList = service.getQueryStudent_class_id();
			if (classIdList.size() < 1) {
				return INPUT;
			}
			if(classIdList.contains(-1)){
				classIdList.remove(new Integer(-1));
			}
			model.addAttribute("id", adid);
			model.addAttribute("classIdList", classIdList);
			model.addAttribute("allstudentList", otherstudentList);
			model.addAttribute("studentList", studentList);
		} catch (TaskException e) {
			throw e;
		}
		return "online_manngerStudent";	
	}
	@RequestMapping(value={"/query_student_byclassId"})
	@ResponseBody
	public JsonData executeAction3(String classid) throws Exception{
		String result = SUCCESS;
		List<StudentModel> studentList;
		try {
			studentList = service.getStudentByclass_id(Integer.valueOf(classid));
			if (studentList.size() < 1) {
				//addActionError(this.getText("I004"));
				//return INPUT;
			}
			//model.addAttribute("classdstudentList", studentList);
		} catch (TaskException e) {
			throw e;
		}
		
		return JsonData.success(studentList);
	}
	
	@RequestMapping(value={"/change_student_byclassId"})
	public String executeAction3( String cur_classid , String stu_id_remove,String stu_id_add) throws Exception{
		String result = SUCCESS;
		try {
			List<Long> removelist=getAdidList(stu_id_remove);
			List<Long> addlist=getAdidList(stu_id_add);
			List<Long> commonID=removelist.stream().filter(x -> addlist.contains(x)).collect(Collectors.toList());
			removelist.removeAll(commonID);
			addlist.removeAll(commonID);
			 if(removelist!=null&&removelist.size()>0){
				 Map params = new HashMap();
		         params.put("ids", removelist);
		         params.put("class_id",-1);
		         int count  = service.changeStduentClassId(params);
					if (count < 1) {
						//addActionError(this.getText("I007"));
						return INPUT;
					}
			 }
			 if(addlist!=null&&addlist.size()>0){
				 Map params = new HashMap();
		         params.put("ids", addlist);
		         params.put("class_id",cur_classid);
		         int count  = service.changeStduentClassId(params);
					if (count < 1) {
						//addActionError(this.getText("I007"));
						return INPUT;
					}
			 }	         			
		} catch (TaskException e) {
			throw e;
		}		
		return result;
	}
	
	
	public List<Long> getAdidList(String playerIds){		
		List<Long> result=new ArrayList<Long>();
		if(playerIds==null&&"".equals(playerIds))
			return result;
		try{
			result=Arrays.asList(playerIds.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());			
		}catch (Exception e) {

		}	
		return result;
	}
	
}
