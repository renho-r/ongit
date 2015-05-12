package com.renho.service.impl;

import com.renho.model.dao.IUserDAO;
import com.renho.model.pojo.impl.User;
import com.renho.service.IUserService;
import com.renho.util.AppException;

public class UserServiceImpl implements IUserService {

	private IUserDAO userDAO;
	
	@Override
	public int save(User user) {
		return userDAO.save(user);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public int saveException(User user) throws Exception {
		int back = userDAO.save(user);
		if("".equals("")) {
			throw new Exception("Exception");			
		}
		return back;
	}

	@Override
	public int saveAppException(User user) throws Exception {
		int back = userDAO.save(user);
		if("".equals("")) {
			AppException e = new AppException("AppException");
			e.setMsgMap("msg", "AppExceptionªÿ÷µmsg");
			throw e;
		}
		return back;
	}

	@Override
	public int saveRuntimeException(User user) {
		int back = userDAO.save(user);
		if("".equals("")) {
			throw new RuntimeException();			
		}
		return back;
	}

}
