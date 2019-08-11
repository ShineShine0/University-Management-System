package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;

public interface AdminDao {
	public void saveAdmin(Admin admin);
	 public List<AdminDTO> getAdminList();
	 public String deleteAdmin(long id);
	 public List<AdminDTO> getAdminRoleList();
	 public AdminDTO getAdminById(long id);

	 

}
