package com.assistantteacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistantteacher.dao.DepartmentDao;

import com.assistantteacher.dto.DepartmentDTO;

import com.assistantteacher.entity.Department;
import com.assistantteacher.entity.UserInfo;

@Service
public class DepartmentServiceImpl  implements DepartmentService{
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public void save(DepartmentDTO departmentDTO) {
		// TODO Auto-generated method stub
		Department department= convertDepartmentBean(departmentDTO);
	}
	
	private Department convertDepartmentBean(DepartmentDTO departmentDTO){
		Department department=new Department();
		
		UserInfo userInfo=new UserInfo();
		if(departmentDTO.getId()!=0){
			department.setId(departmentDTO.getId());
		}
		department.setName(departmentDTO.getName());
		return department;
	}

	@Override
	public Boolean deleteDepartment(long id) {
		// TODO Auto-generated method stub
		return departmentDao.deleteDepartment(id);
	}

	@Override
	public List<DepartmentDTO> getDepartmentList() {
		// TODO Auto-generated method stub
		return departmentDao.getDepartmentList();
	}

}
