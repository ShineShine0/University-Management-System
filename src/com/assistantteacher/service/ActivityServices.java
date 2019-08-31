package com.assistantteacher.service;

import java.util.List;

import com.assistantteacher.dto.ActivityDTO;
import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;

public interface ActivityServices {
	public List<ClassLevel>getClassLevelList();
	public List<Section>getSectionList();
	public List<Section>retrieveSectionByClassLevelId(Long classLevelId);
	public String getTeacherName(Long id);
	public List<Student> retrieveStudent(long classLevelId, long sectionId);
	public void saveActivity(ActivityDTO activityDTO);
	public List<Activity> getActivityListByUserId(long userId);
	public void updateActivity(ActivityDTO activityDTO);
	public Boolean delete(long id);

}
