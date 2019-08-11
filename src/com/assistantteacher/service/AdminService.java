package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.entity.Admin;

public interface AdminService {
	public void save(AdminDTO AdminDTO);	
	public List<AdminDTO> getAdminList();
	public List<AdminDTO> getAdminRoleList();
	public void saveAdmin(AdminDTO admin);
	public String deleteAdmin(long id);
	public AdminDTO getAdminById(long id);
	public void updateMember(AdminDTO admin);

}
