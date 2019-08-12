package com.assistantteacher.dao;

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
import com.assistantteacher.entity.Attendance;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

public interface AttendanceDao {
	
	 List<Subject>getSubjectList();
	 List<ClassLevel>getClassLevelList();
	 List<Section>getSectionList();
	 List<SubjectDTO> getSubjectListByClassLevel(Long classLevelId, Long majorId );
	 List<Section>getSectionListByClassLevel(Long classLevelId);
	 List<Major> getMajorList();
	 List<AttendanceStudentDTO> getAttendanceStudentByMajorAndSection(AttendanceDTO attDTO);
	 void saveAttendance(Attendance att);
	 public List<AttMonthDTO> getAttMonthListByClassLevelAndSection(AttendanceDTO attDTO);
	List<AttendanceDTO> getSubjectByClassLevel(Long classLevelId, Long majorId,
			Long subjectId);
	public List<AttSemesterDTO> getAttListBySemester(AttendanceDTO attDTO,List<MonthDTO> monList);
	public List<Double> getAttendanceListByMonth(Long stdId,Long classLevelId,List<MonthDTO> monthList);
	public List<Double> getAttendanceListBySubject(Long stdId,Long classLevelId,int month,List<SubjectDTO> subjectList);
	public List<AttSubjectDTO> getAttListBySubject(AttendanceDTO attDTO);
	public List<AttSubjectDTO> getAttListByMonth(AttendanceDTO attDTO);
	public List<AttDateDTO> getAttListByDate(AttendanceDTO attDTO);
	public List<MonthAttDTO> getAttListBySemesterForStudent(Long userId,List<MonthDTO> monList);
	public List<SubjectAttDTO> getSubjectAttendanceForStudent(Long userId,int month);
 
}
