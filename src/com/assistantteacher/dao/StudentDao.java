package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Student;



public interface StudentDao {
   
	 public void saveStudent(Student student);
	 public List<StudentDTO> getStudentList();
	 public Boolean deleteStudent(long id);
	 public List<StudentDTO> getClassLevelList();
	 public List<StudentDTO> getMajorList();
	 public List<StudentDTO> getSectionList();
	 public List<StudentDTO> getAdminRoleList();
	 public StudentDTO getStudentById(long id);
}
