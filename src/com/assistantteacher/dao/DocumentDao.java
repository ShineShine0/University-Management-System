package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Document;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface DocumentDao {
	

	List<Subject> getSubjectList();
	List<ClassLevel>getClassLevelList();
             List<Section>getSectionList();
	List<Subject> getSubjectListByClassLevel(Long classLevelId);
	List<Section>getSectionListByClassLevel(Long classLevelId);
	void saveDocument(Document d);
	List<DocumentDTO> getDocumentListByUser(Long userId);
	DocumentDTO getDocumentListById(long id);
	List<DocumentDTO> getDocumentListByTeacherId(Long userId) ;
	Boolean delete(long id);

}
