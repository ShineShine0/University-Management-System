package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.ClassLevelDTO;
import com.assistantteacher.dto.SectionDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface ClassLevelService {
	void saveClassLevel(ClassLevelDTO classLevel);
	List<ClassLevel> retrieve();
	void update(SectionDTO section);
	ClassLevelDTO getClassLevelById(long id);
	Boolean delete(long id);
	public List<Admin> retrieveAdminList();
	List<Section> retrieveSection();
	void saveSection(SectionDTO section);
	Boolean deleteSection(long id);
	public List<ClassLevelDTO> getMajorList();
	Boolean deleteClassLevel(long id);
	SectionDTO getSectionById(long id);
	void update(ClassLevelDTO classlevel);
	void saveSubject(SubjectDTO subject);
	List<SubjectDTO> retrieveSubject();
	
	

}
