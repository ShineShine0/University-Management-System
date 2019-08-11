package com.assistantteacher.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistantteacher.dao.ActivityDao;
import com.assistantteacher.dto.ActivityDTO;
import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
@Service
public class ActivityServicesImpl implements ActivityServices {
		@Autowired
		private ActivityDao activityDAO;
		@Override
		public List<ClassLevel>getClassLevelList(){
			return activityDAO.getClassLevelList();
		}
		public List<Section>getSectionList(){
			return activityDAO.getSectionList();
		}
		@Override
		public List<Section>retrieveSectionByClassLevelId(Long classLevelId){
			return activityDAO.getSectionListByClassLevel(classLevelId);	
		}
		@Override
		public String getTeacherName(Long id) {
			return activityDAO.getTeacherName(id);
		}
		@Override
		public List<Student> retrieveStudent(long classLevelId, long sectionId) {
			return activityDAO.getStudentList(classLevelId,sectionId);
		}
		@Override
		public void saveActivity(ActivityDTO activityDTO) {
			Activity activity = new Activity();
			activity = beanConvertToActivity(activityDTO);
			activityDAO.saveActivity(activity);
		}
		private Activity beanConvertToActivity(ActivityDTO activityDTO) {
			Activity activity =new Activity();
			activity.setDate(activityDTO.getDate());
			
			activity.setDescription(activityDTO.getTitle());
			if (activityDTO.getId()!= null){
				activity.setId(activityDTO.getId());
			}
			activity.getClassLevel().setId(activityDTO.getClassLevelId());
			activity.getSection().setId(activityDTO.getSectionId());
			activity.getTeacher().setId(activityDTO.getTeacherId());
			return activity;
		}
		@Override
		public List<Activity> getActivityListByUserId(long userId) {
			// TODO Auto-generated method stub
			return activityDAO.getActivityListByUserId(userId);
		}
		@Override
		public void updateActivity(ActivityDTO activity) {
			// TODO Auto-generated method stub
			Activity activity1=new Activity();
			
			activityDAO.saveActivity(activity1);
			
			
		}
	
		
	
	/*	@Override
		public void updateActivity(ActivityDTO activityDTO) {
			// TODO Auto-generated method stub
			
		}*/
	
	
		}
