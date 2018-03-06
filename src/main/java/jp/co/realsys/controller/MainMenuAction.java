/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * �������j���[�A�N�V�����N���X
 * 
 * @author Realsys
 */
@Controller
public class MainMenuAction{

	private static final long serialVersionUID = -5272046073153643259L;

	/**
	 * Action�N���X�̎��s���\�b�h�B<br>
	 * 
	 * @param mapping �J�ڐ���
	 * @param form Form���
	 * @param request ���N�G�X�g���
	 * @param response ���X�|���X���
	 * @return �A�N�V�����t�H���[�h
	 * @throws Exception ��O�G���[
	 * */
	@RequestMapping(value={"/menu"},method={RequestMethod.GET},params = "actionType")
	public String executeAction(HttpServletRequest req) throws Exception {
		
		String forward = "SUCCESS";
		String actionType = "none";
		actionType=req.getParameter("actionType");
		if ("register".equals(actionType)) {
			forward = "register";
		} else if ("query".equals(actionType)) {
			forward = "query";
		} else if ("delete".equals(actionType)) {
		forward = "delete";
		} else if ("update".equals(actionType)) {
			forward = "update";
		}/*else if ("online_mannger".equals(actionType)) {
			forward = "online_mannger";
		}*/
		return forward+"Student";
	}

}
