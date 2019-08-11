package com.assistantteacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.service.AdminService;
import com.assistantteacher.service.DepartmentService;
import com.assistantteacher.util.Nationality;

@Controller
@RequestMapping(value="/admin")
public class ManagementController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="/addmember.htm")
	public String addMermberGet(Model model){
		model.addAttribute("adminDTO", new AdminDTO());
		model.addAttribute("nationality", Nationality.values());
		model.addAttribute("adminList", adminService.getAdminList());
		model.addAttribute("userRole", adminService.getAdminRoleList());
		model.addAttribute("departmentList",departmentService.getDepartmentList());
	
		return"addMember";
	}
	
	@RequestMapping(value="/addMember.htm", method = RequestMethod.POST)
	public String addMermberPost(Model model,@ModelAttribute(value="adminDTO")AdminDTO admin){
		
		adminService.saveAdmin(admin);
		
		
		return"redirect:/admin/addmember.htm";
	}
	
	@RequestMapping(value="/ajax/delete-admin/{id}",method=RequestMethod.GET)
	public  @ResponseBody String deleteAdmin(Model model,@PathVariable(value="id")long id){
		return  adminService.deleteAdmin(id);
	}
	@RequestMapping(value="/editMember.htm/{id}")
	public String updateAdmin(Model model,@PathVariable(value="id")long id){
	//	model.addAttribute("adminDTO", new AdminDTO());
		model.addAttribute("nationality", Nationality.values());
		model.addAttribute("adminList", adminService.getAdminList());
		model.addAttribute("userRole", adminService.getAdminRoleList());
		model.addAttribute("departmentList",departmentService.getDepartmentList());
		model.addAttribute("adminDTO", adminService.getAdminById(id));
		return "updateMember";
}

	@RequestMapping(value="/updateMember.htm", method = RequestMethod.POST)
	public String updatememberPost(Model model,@ModelAttribute(value="adminDTO")AdminDTO admin){
		adminService.updateMember(admin);
		return"redirect:/admin/addmember.htm";
	}
}
