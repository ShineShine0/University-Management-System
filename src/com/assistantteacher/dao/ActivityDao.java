package com.assistantteacher.dao;

import java.util.List;

import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;

public interface ActivityDao {
	
	public List<ClassLevel>getClassLevelList();
	public List<Section>getSectionList();
	List<Section>getSectionListByClassLevel(long classLevelId);
	public String getTeacherName(Long id);
	public List<Student> getStudentList(long classLevelId, long sectionId);
	public void saveActivity(Activity activity);
	public List<Activity> getActivityListByUserId(long userId);

}
