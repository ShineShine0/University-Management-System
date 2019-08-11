package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.DepartmentDTO;
import com.assistantteacher.entity.Department;


public interface DepartmentDao {
	public void saveDepartment( Department  department);
	 public List< DepartmentDTO> getDepartmentList();

	 public Boolean deleteDepartment(long id);

}
