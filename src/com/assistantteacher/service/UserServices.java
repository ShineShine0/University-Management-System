package com.assistantteacher.service;

import org.apache.catalina.User;

import sun.security.util.Password;

import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.UserInfo;

public interface UserServices {
	public UserInfo adminAuthenticate(String email, String password);

	public boolean changeUserPassword(User user, String newPassword);

	public Long getUserCount();

	public Long getStudentCount();

	public Long getSubjectCount();

	public Long getAdminCount();

	public Boolean checkUser(String email);

/*	public User findUserByEmail(String userEmail);

	public void createPasswordResetTokenForUser(User user, String token);*/
}
