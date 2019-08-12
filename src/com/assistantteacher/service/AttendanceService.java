package com.assistantteacher.service;

import java.util.Date;
import java.util.List;

import com.assistantteacher.dto.AttDateDTO;
import com.assistantteacher.dto.AttMonthDTO;
import com.assistantteacher.dto.AttSemesterDTO;
import com.assistantteacher.dto.AttSubjectDTO;
import com.assistantteacher.dto.AttendanceDTO;
import com.assistantteacher.dto.AttendanceStudentDTO;
import com.assistantteacher.dto.MonthAttDTO;
import com.assistantteacher.dto.MonthDTO;
import com.assistantteacher.dto.SubjectAttDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface AttendanceService {
	
	public List<ClassLevel> getClassLevelList();
	public List<Section> getSectionList();
	public List<Section> retrieveSectionByclassLevelId(Long classLevelId) ;
	public List<Major> getMajorList();
	public List<AttendanceStudentDTO> getAttendanceStudentByMajorAndSection(AttendanceDTO attDTO);
	public void saveAttendanceList(AttendanceDTO attDTO);
	public List<MonthDTO> getMonthList();
	public List<AttMonthDTO> getAttMonthListByClassLevelAndSection(AttendanceDTO attDTO);
	public List<MonthDTO> getMonthListByFromTo(int from, int month);
	/*public List<AttendanceDTO> retrieveSubjectByclassLevelId(Long classLevelId,
			Long majorId, Long subjectId);*/
	public List<SubjectDTO> retrieveSubjectByclassLevelId(Long classLevelId,Long majorId);
	public List<AttSemesterDTO> getAttListBySemester(AttendanceDTO attDTO);
	public List<AttSubjectDTO> getAttListBySubject(AttendanceDTO attDTO);
	public List<AttSubjectDTO> getAttListByMonth(AttendanceDTO attDTO);
	public List<Integer> getDayListByMonth(int month);
	public List<AttDateDTO> getAttListByDate(AttendanceDTO attDTO);
	List<Subject> getSubjectList();
	public List<MonthAttDTO> getAttListBySemesterForStudent(Long userId);
	public List<SubjectAttDTO> getSubjectAttendanceForStudent(Long userId);
	
}
