/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.dao;

import java.util.List;
import java.util.Map;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;

/**
 * �w�����DAO�N���X
 * 
 * @author Realsys
 */
public interface StudentDao {
	public int changeStduentClassId(Map pmodel) throws TaskException;
	public List<StudentModel> getStudentByclass_id(int class_id) throws TaskException;
	public List<StudentModel> getQueryALlStudent() throws TaskException;
	public List<Integer> getQueryStudent_class_id() throws TaskException;
	public List<StudentModel> getQueryotherALlStudent(String adid) throws TaskException;
	
    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
	public int doRegisterStduent(StudentModel student) throws TaskException;
	
    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
	public int doUpdateStduent(StudentModel student) throws TaskException;

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
     */
	public int doDeleteStduent(String studentId) throws TaskException;
	
    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
	public List<StudentModel> doQueryStduentList(String name) throws TaskException;
	
    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     * @throws TaskException 
     */
    public StudentModel getQueryStudentById(String id) throws TaskException;
    
}
