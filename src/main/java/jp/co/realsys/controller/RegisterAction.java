/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;


/**
 * �o�^�A�N�V�����N���X
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
			// ���݃`�F�b�N
			StudentModel studentExist = service.doQueryStduentId(model.getId());
			if (studentExist!=null){
				return INPUT;
			}
			// �o�^
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
