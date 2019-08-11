package com.assistantteacher.service;
import java.text.SimpleDateFormat;












import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.security.util.Password;

import com.assistantteacher.dao.UserDao;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.UserInfo;
@Service
public class UserServicesImlp implements UserServices{
	@Autowired
	private UserDao userDao;	
	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	@Override
	public UserInfo adminAuthenticate(String email, String password) {
		UserInfo admin_user = userDao.adminAuthenticate(email, password);
		return admin_user;
	}

	@Override
	public boolean changeUserPassword(User user, String newPassword) {
		if(newPassword!="") {
			user.setPassword(newPassword);
		 return userDao.saveUserForResetPassword(user);
		}
		return false;
	}

	@Override
	public Long getUserCount() {
		return userDao.getUserCount();
	}

	@Override
	public Long getStudentCount() {
		
		return userDao.getStudentCount();
	}

	@Override
	public Long getSubjectCount() {
		
		return userDao.getSubjectCount();
	}

	@Override
	public Long getAdminCount() {
		
		return userDao.getAdminCount();
	}

	@Override
	public Boolean checkUser(String email) {
		return userDao.checkUser(email);
	}


}
