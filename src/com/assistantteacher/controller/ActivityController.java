package  com.assistantteacher.controller;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.ActivityDTO;
import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
import com.assistantteacher.service.ActivityServices;
import com.assistantteacher.service.UserServices;
import com.assistantteacher.util.SecurityUtil;
  @Controller
  @RequestMapping(value = "/teacher")
  public class ActivityController {
	  @Autowired
	  private ActivityServices activityService;
	  @Autowired
		private JavaMailSender mailSender;
	  
		@RequestMapping(value = "/addActivity.htm")
		public String addActivity(Model model) {
			String email = SecurityUtil.getCurrentLoginAdminUser().getUserName();
			Long id = SecurityUtil.getCurrentLoginAdminUser().getId();
			model.addAttribute("teacherMail",email);
			model.addAttribute("teacherName",activityService.getTeacherName(id));
			model.addAttribute("teacherId", id);
			model.addAttribute("activityDTO",new ActivityDTO());
			model.addAttribute("classLevelList",activityService.getClassLevelList());
			model.addAttribute("sectionList",activityService.getSectionList());
			model.addAttribute("activityList", activityService.getActivityListByUserId(id));
			return "addActivity";
		}
		@RequestMapping(value="/checkActivity.htm")
		public String listTable(Model model){
			Long userId=SecurityUtil.getCurrentLoginAdminUser().getId();
			List<Activity>activityList=activityService.getActivityListByUserId(userId);
			model.addAttribute("activityList", activityList);
			return "checkactivityList";
		}
		
@RequestMapping(value = "/ajax/get-section-list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<Section>getSectionList(@RequestParam(value="classLevelId",required=true)long classLevelId)
	{
		return activityService.retrieveSectionByClassLevelId(classLevelId);
	}

@RequestMapping(value = "/ajax/get-student-list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody List<Student>getStudentList(@RequestParam(value="classLevelId",required=true)long classLevelId,
		@RequestParam(value="sectionId",required=true)long sectionId)
	{
		return activityService.retrieveStudent(classLevelId,sectionId);
	}

@RequestMapping(value = "/addActivity.htm", method = RequestMethod.POST)

public String saveActivity(Model model, @ModelAttribute(value = "activityDTO") ActivityDTO activityDTO,
		BindingResult result) {
	if(!result.hasErrors()){
		activityService.saveActivity(activityDTO);
		if(activityDTO.getMailUserList().size() > 0 ){
			for(ActivityDTO activity : activityDTO.getMailUserList() ){
				if(activity.getStatus() != null){
				mailSender.send(constructEmail(activity.getEmail() , activityDTO.getTitle(),activityDTO.getTeacherName()));
				}
			}
		}
	}
	return "redirect:/teacher/checkActivity.htm";
}

/*@RequestMapping(value="/addActivity.htm",method=RequestMethod.POST)

public void updateActivity(Model model,  @ModelAttribute(value="activityDTO")ActivityDTO activityDTO,
		BindingResult result){
	if(!result.hasErrors()){
		activityService.updateActivity(activityDTO);
		if(activityDTO.getMailUserList().size()>0){
			for(ActivityDTO activity :activityDTO.getMailUserList()){
				if(activity.getStatus()!=null){
					mailSender.send(constructEmail(activity.getEmail(), activityDTO.getTitle(),activityDTO.getTeacherName()));
					
				}
			}
		}
		
	}
}*/
private SimpleMailMessage constructEmail(String email, String title, String tacher) {
	final SimpleMailMessage mail = new SimpleMailMessage();
	mail.setSubject("Activity Detail from Daw" + tacher);
	mail.setText(title);
	mail.setTo(email);
	System.out.print(email);
	mail.setFrom("infoava123@gmail.co");
    return mail;
}
@RequestMapping(value="activityList.htm")
public String viewActivity(Model model){
	Long userId=SecurityUtil.getCurrentLoginAdminUser().getId();
	List<Activity>activityList=activityService.getActivityListByUserId(userId);
	model.addAttribute("activityList", activityList);
	return "activityList";
	
}
@RequestMapping(value="/update_Activity.htm/{id}")
public @ResponseBody String update(Model model,@PathVariable (value="id")Long id){
	ActivityDTO activity=new ActivityDTO();
	activityService.getActivityListByUserId(id);
	activityService.updateActivity(activity);
	return"redirect:/teacher/add_Activity.htm";
	
}
/*@RequestMapping(value="/ajax/delete-document/{id}")
public @ResponseBody Boolean deleteLessonPlan(Model model,@PathVariable(value="id")long id){
	return activityService.delete(id);
}*/
	
}