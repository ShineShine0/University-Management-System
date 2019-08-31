package com.assistantteacher.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.service.DocumentService;
import com.assistantteacher.util.SecurityUtil;

@Controller
@RequestMapping(value="/teacher")
public class LessonPlanContoller {
	@Autowired
	private DocumentService documentService;
	
	
	@RequestMapping(value="/addLessonPlan.htm")
	public String showLessonPlan(Model model){
		model.addAttribute("lessonPlanDto",new DocumentDTO());
		model.addAttribute("subjectList", documentService.getSubjectList());
		model.addAttribute("classLevelList",documentService.getClassLevelList());
		model.addAttribute("sectionList",documentService.getSectionList());
		return "lessonPlan";
	
	}
	
	@RequestMapping(value="/saveLessonPlan.htm", method = RequestMethod.POST)
	public String saveLessonPlan(Model model,@ModelAttribute(value="lessonPlanDto") DocumentDTO document){
		System.out.println("\n\n\n Save Lesson Plan >>>>>>>" );
		documentService.saveDocument(document);
		return "redirect:/teacher/checkLessonPlan.htm";
	}
	@RequestMapping(value="/checkLessonPlan.htm")
	public String listTable(Model model){
		Long userId = SecurityUtil.getCurrentLoginAdminUser().getId();
		List<DocumentDTO> documentTable = documentService.getDocumentListByTeacherId(userId);
		model.addAttribute("documentTable",documentTable);
		return "checkLessonPlan";
	}
	@RequestMapping(value = "/ajax/get-subject-list", method = RequestMethod.GET)
	public @ResponseBody List<Subject> getSubjectList(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId) {
		return documentService.retrieveSubjectByclassLevelId(classLevelId);
	}
	@RequestMapping(value = "/ajax/get-section-list", method = RequestMethod.GET)
	public @ResponseBody List<Section> getSectionList(
			@RequestParam(value = "classLevelId", required = true) Long classLevelId) {
		return documentService.retrieveSectionByclassLevelId(classLevelId);
	}
	@RequestMapping(value="/viewLessonPlan.htm")
	public String viewLessonPlan(Model model){
		Long userId = SecurityUtil.getCurrentLoginAdminUser().getId();
		//model.addAttribute("searchDto",new DocumentDto());
		List<DocumentDTO> documentList = documentService.getDocumentListByUser(userId);
		model.addAttribute("documentList",documentList);
		
		//model.addAttribute("subjectList",documentService.getSubjectList());
		return "viewLessonPlan";	
	}
	@RequestMapping(value="/detailLessonPlan.htm/{id}")
	public String detailLessonPlan(Model model,@PathVariable(value="id")long id){
		model.addAttribute("document", documentService.getDocumentListById(id));
		return "detailLessonPlan";
	}
	@RequestMapping(value="/ajax/delete-document/{id}")
	public @ResponseBody Boolean deleteLessonPlan(Model model,@PathVariable(value="id")long id){
		return documentService.delete(id);
	}
	@RequestMapping(value="/editDocument.htm/{id}")
	public String updateDocument(Model model,@PathVariable(value="id")Long id){
		//DocumentDto document=new DocumentDto();
		model.addAttribute("subjectList", documentService.getSubjectList());
		model.addAttribute("classLevelList",documentService.getClassLevelList());
		model.addAttribute("sectionList",documentService.getSectionList());
		model.addAttribute("documentDto",documentService.getDocumentById(id));
		//documentService.updateDocument(document);
		return "updateLessonPlan";
	}
	@RequestMapping(value="/updateLessonPlan.htm", method = RequestMethod.POST)
	public String updateLessonPlan(Model model,@ModelAttribute(value="documentDto") DocumentDTO document){
		documentService.saveDocument(document);
		return "redirect:/teacher/checkLessonPlan.htm";
	}
}

