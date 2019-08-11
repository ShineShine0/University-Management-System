package com.assistantteacher.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;

import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.UserInfo;



public class SecurityUtil {
	@Autowired
	@Qualifier("sessionRegistry")
	private static SessionRegistry sessionRegistry;

	public static boolean isAuthenticated() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return !(authentication instanceof AnonymousAuthenticationToken);
	}

	public static UserInfo getCurrentLoginAdminUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() != null && authentication.getPrincipal() instanceof UserInfo) {
			UserInfo user = (UserInfo) authentication.getPrincipal();
			return user;
		}
		else {
			return null;
		}
	}
	public static List<String> getAllUser(){
		List<Object> principals = sessionRegistry.getAllPrincipals();

		List<String> usersNamesList = new ArrayList<String>();

		for (Object principal: principals) {
		    if (principal instanceof User) {
		        usersNamesList.add(((User) principal).getUsername());
		    }
		}
		return usersNamesList;
	}
}
