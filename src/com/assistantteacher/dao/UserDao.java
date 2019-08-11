package com.assistantteacher.dao;


import java.util.Date;
import java.util.List;

import org.apache.catalina.User;

import sun.security.util.Password;

import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.UserInfo;
public interface UserDao {
	public UserInfo adminAuthenticate(String email, String password);

	public boolean saveUserForResetPassword(User user);

	public Long getUserCount();

	public Long getStudentCount();

	public Long getSubjectCount();

	public Long getAdminCount();

	public Boolean checkUser(String email);

}
