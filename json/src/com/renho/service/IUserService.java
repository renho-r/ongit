package com.renho.service;

import com.renho.model.pojo.impl.User;
import com.renho.util.AppException;

public interface IUserService {

	public int save(User user);
	public int saveException(User user) throws Exception;
	public int saveAppException(User user) throws Exception;
	public int saveRuntimeException(User user);
}
