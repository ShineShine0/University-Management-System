package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.DepartmentDTO;



public interface DepartmentService {
public void save(DepartmentDTO departmentDTO);
	
	public Boolean deleteDepartment(long id);
	
	public List<DepartmentDTO> getDepartmentList();
}
