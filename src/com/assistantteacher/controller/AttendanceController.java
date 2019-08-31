package com.assistantteacher.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.AttendanceDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.service.AttendanceService;
import com.assistantteacher.util.SecurityUtil;

@Controller
@RequestMapping(value="/admin")
public class AttendanceController {
	@Autowired
	private AttendanceService attendanceService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(value="/attendance.htm")
	public String createAttendance(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("attDTO",new AttendanceDTO());
		model.addAttribute("subjectList", attendanceService.getSubjectList());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());		
		return "attendanceManagement";
	}
	@RequestMapping(value="/search_attendance.htm",method=RequestMethod.POST)
	public String searchAttendance(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		
		//attDTO.setAttStudentList();
		
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("studentList",attendanceService.getAttendanceStudentByMajorAndSection(attDTO));
		model.addAttribute("attDTO",attDTO);
		model.addAttribute("subjectList", attendanceService.getSubjectList());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		
		return "attendanceManagement";
	}
	@RequestMapping(value = "/ajax/get-subject-list-for-attendance", method = RequestMethod.GET)
	public @ResponseBody List<SubjectDTO> getSubjectList(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId,@RequestParam(value = "majorId", required = true) Long majorId) {
		return attendanceService.retrieveSubjectByclassLevelId(classLevelId,majorId);
		
	}
	@RequestMapping(value = "/ajax/get-section-list-for-subject", method = RequestMethod.GET)
	public @ResponseBody List<Section> getSectionList(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId) {
		return attendanceService.retrieveSectionByclassLevelId(classLevelId);

	}
	@RequestMapping(value = "/ajax/get-section-list-for-attendance", method = RequestMethod.GET)
	public @ResponseBody List<Section> getSectionListAttendanceSubject(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId) {
		return attendanceService.retrieveSectionByclassLevelId(classLevelId);

	}
	@RequestMapping(value = "/ajax/get-subject-list-for-attendancesubject", method = RequestMethod.GET)
	public @ResponseBody List<SubjectDTO> getSectionListAttendance(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId,@RequestParam(value = "majorId", required = true) Long majorId) {
		System.out.print("\n\n\n >>>>>>> test");
		return attendanceService.retrieveSubjectByclassLevelId(classLevelId,majorId);

	}
	/*@RequestMapping(value = "/ajax/get-subject-list-for-attendancesubject", method = RequestMethod.GET)
	public @ResponseBody List<SubjectDTO> getSectionListAttendance(
		@RequestParam(value = "majorId", required = true) Long majorId,@RequestParam(value = "subjectId", required = true) Long subjectId) {
		return attendanceService.retrieveSubjectBymajorId(majorId,subjectId);

	}*/
	@RequestMapping(value="/saveAttendance.htm",method=RequestMethod.POST)
	public String saveAttendance(@ModelAttribute(value="attDTO") AttendanceDTO attDTO){
		attDTO.setUserId( SecurityUtil.getCurrentLoginAdminUser().getId());
		attendanceService.saveAttendanceList(attDTO);
		return "redirect:/admin/attendance.htm";
	}
	@RequestMapping(value="attendanceListBySubject.htm")
	public String getAttendanceBySubject(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("majorList",attendanceService.getMajorList());		
		model.addAttribute("subjectList",attendanceService.getSubjectList());
		model.addAttribute("monthList",attendanceService.getMonthList());
		return "attendanceSubject";
	}
	/*@RequestMapping(value="search_attendanceListBySubject.htm",method=RequestMethod.POST)
	public String searchAttendanceBySubject(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("subjectList",attendanceService.getSubjectList());
		return "attendanceSubject";
	}
	*/
	@RequestMapping(value="attendanceListByDate.htm")
	public String getAttendanceByDate(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		
		return "attendanceDate";
	}
	@RequestMapping(value="attendanceListByMonth.htm")
	public String getAttendanceByMonth(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("monthList",attendanceService.getMonthList());
		return "attendanceMonth";
	}
	@RequestMapping(value="attendanceListBySemester.htm")
	public String getAttendanceBySemester(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("monthList",attendanceService.getMonthList());
		return "attendanceSemester";
	}
	@RequestMapping(value="search_attendanceListBySemester.htm",method=RequestMethod.POST)
	public String searchAttendanceByMonth(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("monthList",attendanceService.getMonthList());
		model.addAttribute("attMonthList",attendanceService.getMonthListByFromTo(attDTO.getFromMonth(), attDTO.getToMonth()));
		model.addAttribute("attStudentList",attendanceService.getAttListBySemester(attDTO));
		return "attendanceSemester";
	}
	@RequestMapping(value="search_attendanceListBySubject.htm",method=RequestMethod.POST)
	public String searchAttendanceBySubject(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("majorList",attendanceService.getMajorList());		
		model.addAttribute("subjectList",attendanceService.getSubjectList());
		model.addAttribute("attSubjectList",attendanceService.retrieveSubjectByclassLevelId(attDTO.getClassLevelId(), attDTO.getMajorId()));
		model.addAttribute("monthList",attendanceService.getMonthList());
		model.addAttribute("attStudentList",attendanceService.getAttListBySubject(attDTO));
		model.addAttribute("dayList", attendanceService.getDayListByMonth(attDTO.getMonth()));
		return "attendanceSubject";
	}
	
	@RequestMapping(value="search_attendanceListByMonth.htm",method=RequestMethod.POST)
	public String getAttendanceByMonth(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("majorList",attendanceService.getMajorList());		
		model.addAttribute("subjectList",attendanceService.getSubjectList());
		model.addAttribute("attSubjectList",attendanceService.retrieveSubjectByclassLevelId(attDTO.getClassLevelId(), attDTO.getMajorId()));
		model.addAttribute("monthList",attendanceService.getMonthList());
		model.addAttribute("attStudentList",attendanceService.getAttListByMonth(attDTO));
		model.addAttribute("dayList", attendanceService.getDayListByMonth(attDTO.getMonth()));
		return "attendanceMonth";
	}
	@RequestMapping(value="search_attendanceListByDate.htm",method=RequestMethod.POST)
	public String searchAttendanceByDate(@ModelAttribute(value="attendanceDTO") AttendanceDTO attDTO,Model model){
		model.addAttribute("attendanceDTO", attDTO);
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("sectionList",attendanceService.getSectionList());
		model.addAttribute("majorList",attendanceService.getMajorList());		
		model.addAttribute("subjectList",attendanceService.retrieveSubjectByclassLevelId(attDTO.getClassLevelId(), attDTO.getMajorId()));
		//model.addAttribute("attSubjectList",attendanceService.retrieveSubjectByclassLevelId(attDTO.getClassLevelId(), attDTO.getMajorId()));
		model.addAttribute("monthList",attendanceService.getMonthList());
		model.addAttribute("attStudentList",attendanceService.getAttListByDate(attDTO));
		
		return "attendanceDate";
	}
	@RequestMapping(value="/attendanceList.htm'")
	public String attendanceview(Model model){
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		model.addAttribute("subjectList", attendanceService.getSubjectList());
		model.addAttribute("classLevelList",attendanceService.getClassLevelList());
		model.addAttribute("majorList",attendanceService.getMajorList());
		model.addAttribute("sectionList",attendanceService.getSectionList());		
		return "attendanceview";
	}
	@RequestMapping(value="/getStudentAttendance.htm")
	public String getStudentAttendance(Model model){
		 Calendar c = Calendar.getInstance();
		   String monName=c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
		model.addAttribute("attendanceDTO", new AttendanceDTO());
		Long userId = SecurityUtil.getCurrentLoginAdminUser().getId();
		model.addAttribute("monthList",attendanceService.getMonthList());
		model.addAttribute("montAttList", attendanceService.getAttListBySemesterForStudent(userId));
		model.addAttribute("subAttList",attendanceService.getSubjectAttendanceForStudent(userId));
		model.addAttribute("month", monName);
		return "student_attendance";
	}
	
}