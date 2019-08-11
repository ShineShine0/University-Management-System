package com.assistantteacher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistantteacher.dao.ClassLevelDao;
import com.assistantteacher.dto.ClassLevelDTO;
import com.assistantteacher.dto.SectionDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

@Service
public class ClassLevelServiceImpl implements ClassLevelService{
@Autowired
private ClassLevelDao classLevelDao;
	@Override
	public void saveClassLevel(ClassLevelDTO classLevel) {
		ClassLevel cl= new ClassLevel();
		if(cl.getId() !=null) {
			cl.setId(cl.getId());
		}
		cl.setName(classLevel.getName());
		cl.getAdmin().setId(classLevel.getAdminId());
	
		classLevelDao.save(cl);
	}
		
	

	@Override
	public List<ClassLevel> retrieve() {
		return classLevelDao.retrieve();
	}

	@Override
	public void update(ClassLevelDTO classLevel) {
		classLevelDao.update(classLevel);
	}

	@Override
	public ClassLevelDTO getClassLevelById(long id) {
		return classLevelDao.getClassLevelById(id);
	}

	@Override
	public Boolean delete(long id) {
		return classLevelDao.delete(id);
	}

	@Override
	public List<Admin> retrieveAdminList() {
		return classLevelDao.retrieveAdminList();
	}

	@Override
	public List<Section> retrieveSection() {
		return classLevelDao.retrieveSection();
	}

	@Override
	public void saveSection(SectionDTO section) {
		Section se=new Section();
		
		if(section.getId() != null) {
			
			se.setId(section.getId());
		}
		se.setName(section.getName());
		se.getAdmin().setId(section.getAdminId());
		se.getClassLevel().setId(section.getClassLevelId());
	
		classLevelDao.saveSection(se);
	}

	@Override
	public Boolean deleteSection(long id) {
		return classLevelDao.deleteSection(id);
	}



	@Override
	public List<ClassLevelDTO> getMajorList() {
		return classLevelDao.getMajorList();
	}



	@Override
	public Boolean deleteClassLevel(long id) {
		return classLevelDao.deleteClassLevel(id);
	}



	@Override
	public SectionDTO getSectionById(long id) {
		return classLevelDao.getSectionById(id);
	}



	@Override
	public void update(SectionDTO section) {
		classLevelDao.update(section);
		
	}



	@Override
	public void saveSubject(SubjectDTO subject) {
	Subject s=new Subject();
		
		if(subject.getId() != null) {
			
			s.setId(subject.getId());
		}
		s.setName(subject.getName());
		Admin admin=new Admin();
		admin.setId(subject.getAdminId());
		s.getTeacher().add(admin);		
		s.getClassLevel().setId(subject.getClassLevelId());
		for(Long m: subject.getMajorIdList()){
			Major mm= new Major();
			mm.setId(m);
			s.getMajorList().add(mm);
		}
		
		classLevelDao.saveSubject(s);
		
	}



	@Override
	public List<SubjectDTO> retrieveSubject() {
		// TODO Auto-generated method stub
		return classLevelDao.retrieveSubject();
	}

}
