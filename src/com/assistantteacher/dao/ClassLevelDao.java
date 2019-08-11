package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.ClassLevelDTO;
import com.assistantteacher.dto.SectionDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface ClassLevelDao {
	void save(ClassLevel classLevel);
	List<ClassLevel> retrieve(); 
	void update(ClassLevelDTO classLevel);
	ClassLevelDTO getClassLevelById(long id);
    Boolean delete(long id);
    Boolean deleteSection(long id);
    public List<Admin> retrieveAdminList();
    void saveSection(Section section);
    List<Section> retrieveSection(); 
    public List<ClassLevelDTO> getMajorList();
	Boolean deleteClassLevel(long id);
	SectionDTO getSectionById(long id);
	void update(SectionDTO section);
	void saveSubject(Subject subject);
	List<SubjectDTO> retrieveSubject();
	
	
	
}
