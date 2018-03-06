package jp.co.realsys.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.realsys.service.StudentService;
import jp.co.realsys.service.impl.StduentDBServiceImpl;

@Controller
public class DeleteAction {
	private static final String INPUT="error";
	private static final String SUCCESS="deleteResult";
	@Autowired
	private StudentService service;
	@RequestMapping(value={"/delete"})
	public String executeAction(@Param("id") String id ) throws Exception{

		
		String result = SUCCESS;

		if (service.doQueryStduentId(id).getId() != null) {
			service.doDeleteStduent(id);
			//this.addActionMessage(this.getText("I002"));
		} else {
			//this.addActionError(this.getText("I006"));
			return INPUT;
		}
		return result;
	}
}
