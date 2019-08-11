package com.assistantteacher.authentication;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.UserInfo;
import com.assistantteacher.service.UserServices;
public class Admin_AuthenticationProvider implements AuthenticationProvider{
	@Autowired
	private UserServices userService;
	

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserInfo admin_user = userService.adminAuthenticate(email, password);
        if (admin_user != null && admin_user.getRole() != null) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            if(admin_user.getRole().getPriviligesList()!=null){
	            for(int i=0;i<admin_user.getRole().getPriviligesList().size();i++){
	            grantedAuths.add(new SimpleGrantedAuthority(admin_user.getRole().getPriviligesList().get(i).getRoleCode()));
	            }
            }
            Authentication auth = new UsernamePasswordAuthenticationToken(admin_user, null, grantedAuths);
        	return auth;
        } else {
            
            return null;
        }
	}

	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
