package jp.co.realsys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.realsys.dao.UserDao;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.UserModel;
import jp.co.realsys.service.UsersInfoService;

@Service("UsersInfoService") 
public class UsersInfoServiceImpl implements UsersInfoService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public boolean doCheckUser(UserModel model) throws TaskException {
		
		try {
			UserModel userInfo = userDao.getUser(model);
			
			if (userInfo == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw new TaskException(e);
		}
	}
}
