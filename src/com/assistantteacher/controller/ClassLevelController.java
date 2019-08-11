package com.assistantteacher.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.ClassLevelDTO;
import com.assistantteacher.dto.SectionDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.service.ClassLevelService;

@Controller
@RequestMapping(value="/admin")
public class ClassLevelController {

	@Autowired
	private ClassLevelService classLevelService;
	

	
	
	@RequestMapping(value="/saveyear.htm",method=RequestMethod.POST)
	public String saveClassLevel(@Valid @ModelAttribute(value="classlevel")ClassLevelDTO classLevel,Model model,BindingResult result) {
		if(!result.hasErrors()) {
			classLevelService.saveClassLevel(classLevel);
			model.addAttribute("classlevel", new ClassLevelDTO());
			model.addAttribute("adminList",classLevelService.retrieveAdminList());
			model.addAttribute("classLevelList", classLevelService.retrieve());
			model.addAttribute("sectionList", classLevelService.retrieveSection());
			model.addAttribute("section", new SectionDTO());
		}
		
		return "yearManagement";
	}
	
	@RequestMapping(value="/saveSection.htm",method=RequestMethod.POST)
	public String saveSection(@Valid @ModelAttribute(value="section")SectionDTO section,Model model,BindingResult result) {
		if(!result.hasErrors()) {
			classLevelService.saveSection(section);
			model.addAttribute("ClassLevel", new ClassLevelDTO());
			model.addAttribute("adminList",classLevelService.retrieveAdminList());
			model.addAttribute("classLevelList", classLevelService.retrieve());
			model.addAttribute("section", new SectionDTO());
			model.addAttribute("sectionList", classLevelService.retrieveSection());
		}
		
		return "yearManagement";
	}
	
	@RequestMapping(value="/savesubject.htm",method=RequestMethod.POST)
	public String saveSubject(@Valid @ModelAttribute(value="subject")SubjectDTO subject,Model model,BindingResult result) {
		if(!result.hasErrors()) {
			classLevelService.saveSubject(subject);
			model.addAttribute("subjectList", classLevelService.retrieveSubject());
			return "redirect:/admin/class.htm";
		}
		
		return "yearManagement";
	}
	
	
	
	@RequestMapping(value="/class.htm",method=RequestMethod.GET)
	public String editClassLevel(Model model){
		model.addAttribute("classlevel", new ClassLevelDTO());
		List<Admin> aList=classLevelService.retrieveAdminList();
		List<ClassLevel> cList= classLevelService.retrieve();
		List<Section> sList= classLevelService.retrieveSection();
		List<SubjectDTO> subList= classLevelService.retrieveSubject();
		model.addAttribute("adminList",aList);
		model.addAttribute("classLevelList", cList);
		model.addAttribute("sectionList", sList);
		model.addAttribute("subjectList", subList);
		model.addAttribute("majorList",classLevelService.getMajorList());
		model.addAttribute("section", new SectionDTO());
		model.addAttribute("subject", new SubjectDTO());
		return "yearManagement";
		
	}
	
	@RequestMapping(value="/updateSection.htm",method=RequestMethod.POST)
	public String updateSection(@Valid @ModelAttribute(value="section") SectionDTO section,Model model,BindingResult result) {
		if(!result.hasErrors()) {
				classLevelService.update(section);
		}
		return "redirect:/admin/class.htm";
	}	
	@RequestMapping(value="/updateClassLevel.htm",method=RequestMethod.POST)
	public String updateClassLevel(@Valid @ModelAttribute(value="classlevel") ClassLevelDTO classlevel,Model model,BindingResult result) {
		if(!result.hasErrors()) {
				classLevelService.update(classlevel);
		}
		return "redirect:/admin/class.htm";
	}
	@RequestMapping(value="/retrieveclasslevel")
	public String retrieveClassLevel(Model model) {		
		
		model.addAttribute("retrieveclasslevel",classLevelService.retrieve());
		return "classLevelList";
		
	}
	@RequestMapping(value="/editClassLevel.htm/{id}",method=RequestMethod.GET)
	public String updateClassLevel(@PathVariable(value="id") long id,Model model) {
		ClassLevelDTO cl=classLevelService.getClassLevelById(id);
		model.addAttribute("classlevel",cl);
		return "editClassLevel";
	}
	@RequestMapping(value="/editSection.htm/{id}",method=RequestMethod.GET)
	public String updateSection(@PathVariable(value="id") long id,Model model) {
		SectionDTO se=classLevelService.getSectionById(id);
		model.addAttribute("Section",se);
		return "editSection";
	}
	
	
	@RequestMapping(value="/ajax/delete-classLevel/{id}",method=RequestMethod.GET)
	public @ResponseBody Boolean deleteStudent(Model model,@PathVariable(value="id")long id){
		return  classLevelService.deleteClassLevel(id);
	}
	
	
}



