package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Subject;

public interface SubjectDao {
	long save(Subject subject);
	void updateSubject(Subject subject);
	boolean deleteSubject(long id);
	List<SubjectDTO> getSubjectList();
	SubjectDTO getSubjectById(long id);
	public List<SubjectDTO> retrieveClassLevel() ;
	void saveSubject(Subject subject);

}
