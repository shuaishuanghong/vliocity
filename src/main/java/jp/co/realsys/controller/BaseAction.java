/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.controller;

/**
 * 基底アクションクラス
 * 
 * @author Realsys
 */
public abstract class BaseAction{

	/**
	 * Actionクラスの実行メソッド。<br>
	 */
//	public String execute() {
//		String actionResult = NONE;
//		
//		try {
//			actionResult = executeAction();
//		} catch (Exception e) {
//			actionResult = ERROR;
//			this.addActionError(this.getText("E999"));
//		}
//		
//		return actionResult;
//	}

	/**
	 * 指定されたリクエストを処理して、対応するレスポンスを生成する。<br>
	 * 
	 * @param mapping 遷移先情報
	 * @param form Form情報
	 * @param request リクエスト情報
	 * @param response レスポンス情報
	 * @return アクションフォワード
	 * @throws Exception 例外エラー
	 */
	//public abstract String executeAction() throws Exception;
}
