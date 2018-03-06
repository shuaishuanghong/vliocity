/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
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
 * 学生情報データベースの業務層の実装クラス
 * 
 * @author Realsys
 */
@Service
public class StduentDBServiceImpl implements StudentService{
    
    /** 学生情報のDAO */
    @Autowired
	private StudentDao studentDao;
    
    /**
     * 学生情報を登録する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doRegisterStduent(StudentModel student) throws TaskException {
        return studentDao.doRegisterStduent(student);
    }

    /**
     * 学生情報を更新する
     * 
     * @param student 学生情報モデル
     * @return レコード数
     */
    public int doUpdateStduent(StudentModel student) throws TaskException {
        return studentDao.doUpdateStduent(student);
    }

    /**
     * 学生情報を削除する
     * 
     * @param studentId 学生ID
     * @return レコード数
     */
    public int doDeleteStduent(String studentId) throws TaskException {
        return studentDao.doDeleteStduent(studentId);
    }

    /**
     * 学生情報を検索する
     * 
     * @param name 名前
     * @return 学生情報
     */
    public List<StudentModel> doQueryStduentList(String name) throws TaskException {
        return studentDao.doQueryStduentList(name);
    }
    
    /**
     * 学生情報を検索する
     * 
     * @param name 名前
     * @return 学生情報
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
