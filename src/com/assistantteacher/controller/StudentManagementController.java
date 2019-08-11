package com.assistantteacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.service.StudentService;
import com.assistantteacher.util.Citizens;
import com.assistantteacher.util.Nationality;
import com.assistantteacher.util.Religion;
@Controller
@RequestMapping(value="/Student")
public class StudentManagementController {
	@Autowired
    private StudentService studentService;
	@RequestMapping(value="/studentmanagement.htm")
	public String studentWelcome(Model model){
		model.addAttribute("studentDTO", new StudentDTO());
		model.addAttribute("nationality",Nationality.values());
		model.addAttribute("religion", Religion.values());
		model.addAttribute("citizen",Citizens.values());
		model.addAttribute("studentList", studentService.getStudentList());
		model.addAttribute("sectionList", studentService.getSectionList());
		model.addAttribute("majorList", studentService.getMajorList());
		model.addAttribute("classLevelList", studentService.getClassLevelList());
		model.addAttribute("adminRoleList", studentService.getAdminRoleList());
		
		return "studentManagement";
	}
	@RequestMapping(value="/addstudent.htm", method = RequestMethod.POST)
	public String addStudentPost(Model model,@ModelAttribute(value="studentDTO")StudentDTO student){
	
		studentService.saveStudent(student);
		return"redirect:/Student/studentmanagement.htm";
	}
	
	@RequestMapping(value="/Member/ajax/delete-student/{id}",method=RequestMethod.GET)
	public  Boolean deleteStudent(Model model,@PathVariable(value="id")long id){
		return  studentService.deleteStudent(id);
	}
	@RequestMapping(value="/editStudent.htm/{id}")
	public String updateStudent(Model model,@PathVariable(value="id")long id){
		//model.addAttribute("studentDTO", new StudentDTO());
		model.addAttribute("nationality",Nationality.values());
		model.addAttribute("religion", Religion.values());
		model.addAttribute("citizen",Citizens.values());
		model.addAttribute("studentList", studentService.getStudentList());
		model.addAttribute("sectionList", studentService.getSectionList());
		model.addAttribute("majorList", studentService.getMajorList());
		model.addAttribute("classLevelList", studentService.getClassLevelList());
		model.addAttribute("adminRoleList", studentService.getAdminRoleList());
		model.addAttribute("studentDTO",studentService.getStudentById(id));
		return"updateStudent";
	}
	
	@RequestMapping(value="/updatestudent.htm", method = RequestMethod.POST)
	public String updatetudentPost(Model model,@ModelAttribute(value="studentDTO")StudentDTO student){
		studentService.updateStudent(student);
		return"redirect:/Student/studentmanagement.htm";
	}

}
