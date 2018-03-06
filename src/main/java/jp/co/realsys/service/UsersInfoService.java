package jp.co.realsys.service;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.UserModel;

public interface UsersInfoService {

	public boolean doCheckUser(UserModel model) throws TaskException ;
}
