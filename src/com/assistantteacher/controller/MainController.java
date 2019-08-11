package com.assistantteacher.controller;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.PasswordDTO;
import com.assistantteacher.service.UserServices;
import com.assistantteacher.util.SecurityUtil;




@Controller
public class MainController {
	@Autowired
	UserServices userService;
	
	@RequestMapping(value = "/welcome.htm")
	public String loginWelcome(Model model) {
		return "adminLogin";
	}
	
	@RequestMapping(value = "/home.htm")
	public String homeWelcome(Model model) {
		String name = SecurityUtil.getCurrentLoginAdminUser().getUserName();
		model.addAttribute("userName", name);
		return "home";
	}
	
	@RequestMapping(value="/admin_welcome.htm")
	public String showAdmin(Model model) {
		model.addAttribute("userCount", userService.getUserCount());
		model.addAttribute("student",userService.getStudentCount());
		model.addAttribute("subject",userService.getSubjectCount());
		model.addAttribute("teacher",userService.getAdminCount());
		return "adminwelcome";
	}
	@RequestMapping(value = "/resetPassword.htm")
	public String resetPassword(Model model) {
		return "resetPass";
	}
	@RequestMapping(value = "/updatePassword.htm")
	public String updatePassword(Model model) {
		return "updatePassword";
	}
	  @RequestMapping(value = "/user/savePassword", method = RequestMethod.POST)
	    @ResponseBody
	    public boolean savePassword(final Locale locale, @Valid PasswordDTO passwordDto) {
	        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        
	        return userService.changeUserPassword(user, passwordDto.getNewPassword());
	    }
	  
	  @RequestMapping(value="ajax/check-user/{email}",method=RequestMethod.GET)
		public @ResponseBody String testUser(Model model,@PathVariable(value="email")String email){
			return  userService.checkUser(email).toString();
		}
	  	  
	 /* // Reset password
	    @RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
	    @ResponseBody
	    public boolean resetPassword(final HttpServletRequest request, @RequestParam("email") final String userEmail) {
	    	final User user = userService.findUserByEmail(userEmail);
	    	if (user != null) {
	            final String token = UUID.randomUUID().toString();
	            userService.createPasswordResetTokenForUser(user, token);
	            mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
	        
	    	}
	    	 
	    	return true;
	    	}
		
	     private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale, final String token, final User user) {
	        final String url = contextPath + "/user/changePassword?email=" + user.getEmail() + "&token=" + token;
	        final String message ="Reset Password";
	        return constructEmail("Reset Password", message + " \r\n" + url, user);
	    }
	    private String getAppUrl(HttpServletRequest request) {
	        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	    }
	    private SimpleMailMessage constructEmail(String subject, String body, User user) {
	        final SimpleMailMessage email = new SimpleMailMessage();
	        email.setSubject(subject);
	        email.setText(body);
	        email.setTo(user.getEmail());
	        email.setFrom("infoava123@gmail.com");
	        return email;
	    }
	    @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	    public String showChangePasswordPage(final Locale locale, final Model model, @RequestParam("email") final String email, @RequestParam("token") final String token) {
	        final String result = userService.validatePasswordResetToken(email, token);
	        if (result != null) {
	            model.addAttribute("message",result);
	            return "redirect:/login?lang=" + locale.getLanguage();
	        }
	        return "redirect:/updatePassword.htm?lang=" + locale.getLanguage();
	    }*/
	    
	   
}

