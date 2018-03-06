/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * メンメニューアクションクラス
 * 
 * @author Realsys
 */
@Controller
public class MainMenuAction{

	private static final long serialVersionUID = -5272046073153643259L;

	/**
	 * Actionクラスの実行メソッド。<br>
	 * 
	 * @param mapping 遷移先情報
	 * @param form Form情報
	 * @param request リクエスト情報
	 * @param response レスポンス情報
	 * @return アクションフォワード
	 * @throws Exception 例外エラー
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
