package com.renho.e99.section2;

import java.util.Arrays;
import java.util.List;

public class UserHandler<T extends User> {
	// �ж��û��Ƿ���Ȩ��ִ�в���
	public boolean permit(T user, List<Job> jobs) {
		List<Class<?>> iList = Arrays.asList(user.getClass().getInterfaces());
		// �ж��Ƿ��ǹ���Ա
		if (iList.indexOf(Admin.class) > -1) {
			Admin admin = (Admin) user;
			/* �жϹ���Ա�Ƿ��д�Ȩ�� */
		} else {
			/* �ж���ͨ�û��Ƿ��д�Ȩ�� */
		}
		return false;
	}
}

interface User {

}

class UserImpl implements User, Admin {

}

interface Admin {

}

class Job {

}