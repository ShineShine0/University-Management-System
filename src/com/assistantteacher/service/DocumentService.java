package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface DocumentService {
	
	List<Subject> getSubjectList();
    List<ClassLevel>getClassLevelList();
    List<Section>getSectionList();
    List<Subject> retrieveSubjectByclassLevelId(Long classLevelId);
    List<Section> retrieveSectionByclassLevelId(Long classLevelId);
	void saveDocument(DocumentDTO document);
	void save (DocumentDTO documentDto);
	List<DocumentDTO> getDocumentListByUser(Long userId);
	DocumentDTO getDocumentListById(Long id);
	List<DocumentDTO> getDocumentListByTeacherId(Long userId);
	Boolean delete(long id);
	void updateDocument(DocumentDTO document);
	DocumentDTO getDocumentById(long id);

}
