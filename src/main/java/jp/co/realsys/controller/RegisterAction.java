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
 * 登録アクションクラス
 * 
 * @author Realsys
 */
@Controller
public class RegisterAction {
	private static final String INPUT="error";
	private static final String SUCCESS="registerResult";
	@Autowired
	private StudentService service;
	@RequestMapping(value={"/register"})
	public String executeAction(StudentModel model) throws Exception{
		
		try {
			String id=model.getId();
			System.out.println(id+"------------------------------------");
			// 存在チェック
			StudentModel studentExist = service.doQueryStduentId(model.getId());
			if (studentExist!=null){
				return INPUT;
			}
			// 登録
			StudentModel studentInfo = new StudentModel();
			studentInfo.setId(model.getId());
			studentInfo.setName(model.getName());
			studentInfo.setBirthDate(model.getBirthDate());
			studentInfo.setAddress(model.getAddress());
			int count = service.doRegisterStduent(studentInfo);
			if (count < 1) {
				//addActionError(this.getText("I007"));
				return INPUT;
			}
			//this.addActionMessage(this.getText("I001"));
			return SUCCESS;
		} catch (TaskException e) {
			throw e;
		}
	}
}
