/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.realsys.dao.StudentDao;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;

/**
 * �w�����f�[�^�x�[�X�̋Ɩ��w�̎����N���X
 * 
 * @author Realsys
 */
@Service
public class StduentDBServiceImpl implements StudentService{
    
    /** �w������DAO */
    @Autowired
	private StudentDao studentDao;
    
    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doRegisterStduent(StudentModel student) throws TaskException {
        return studentDao.doRegisterStduent(student);
    }

    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doUpdateStduent(StudentModel student) throws TaskException {
        return studentDao.doUpdateStduent(student);
    }

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
     */
    public int doDeleteStduent(String studentId) throws TaskException {
        return studentDao.doDeleteStduent(studentId);
    }

    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public List<StudentModel> doQueryStduentList(String name) throws TaskException {
        return studentDao.doQueryStduentList(name);
    }
    
    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public StudentModel doQueryStduentId(String id) throws TaskException {
        return studentDao.getQueryStudentById(id);
    }

	@Override
	public List<Integer> getQueryStudent_class_id() throws TaskException {
		// TODO Auto-generated method stub
		return studentDao.getQueryStudent_class_id();
	}

	@Override
	public List<StudentModel> getQueryALlStudent() throws TaskException {
		// TODO Auto-generated method stub
		return studentDao.getQueryALlStudent();
	}

	@Override
	public List<StudentModel> getStudentByclass_id(int class_id) throws TaskException {
		// TODO Auto-generated method stub
		return studentDao.getStudentByclass_id(class_id);
	}

	@Override
	public int changeStduentClassId(Map pmodel) throws TaskException {
		// TODO Auto-generated method stub
		return studentDao.changeStduentClassId(pmodel);
	}

	@Override
	public List<StudentModel> getQueryotherALlStudent(String adid) throws TaskException {
		// TODO Auto-generated method stub
		return studentDao.getQueryotherALlStudent(adid);
	}
}
