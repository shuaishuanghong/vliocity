/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;
/**
 * 学生情報の更新アクションクラス
 * 
 * @author Realsys
 */
@Controller
public class UpdateAction{
	private static final String INPUT="error";
	private static final String SUCCESS="updateResult";
	@Autowired
	private StudentService service;
	@RequestMapping(value={"/update"})
	public String executeAction(StudentModel student) throws Exception{
		String result = SUCCESS;
		
		try {
			// IDにより、学生情報の検索
			StudentModel findStudentModel = service.doQueryStduentId(student.getId());

			if (findStudentModel == null) {
				//addActionError(this.getText("I006"));
				return INPUT;
			} else {
				StudentModel studentInfo = new StudentModel();
				studentInfo.setId(student.getId());
				studentInfo.setName(student.getName());
				studentInfo.setBirthDate(student.getBirthDate());
				studentInfo.setAddress(student.getAddress());
				int recode = service.doUpdateStduent(studentInfo);
				if (recode < 1) {
					//addActionError(this.getText("I006"));
					return INPUT;
				}
				//this.addActionMessage(this.getText("I003"));
			}
		} catch (TaskException e) {
			throw e;
		}
		
		return result;
	}
}
