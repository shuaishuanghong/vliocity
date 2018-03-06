/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.error;


/**
 * �ُ�N���X
 * 
 * @author Realsys
 */
public class TaskException extends Exception {

	private static final long serialVersionUID = 58758308927251467L;

	/**
     * TaskException���\�z���܂��B
     */
	public TaskException(String msg) {
		super(msg);
	}
	
	/**
     * TaskException���\�z���܂��B
     */
	public TaskException(Exception msg) {
		super(msg);
	}
}
