package com.assistantteacher.service;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assistantteacher.dao.AttendanceDao;
import com.assistantteacher.dto.AttDateDTO;
import com.assistantteacher.dto.AttMonthDTO;
import com.assistantteacher.dto.AttSemesterDTO;
import com.assistantteacher.dto.AttSubjectDTO;
import com.assistantteacher.dto.AttendanceDTO;
import com.assistantteacher.dto.AttendanceStudentDTO;
import com.assistantteacher.dto.MonthDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Attendance;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceDao attendanceDao;

	@Override
	public List<Subject> getSubjectList() {
		return attendanceDao.getSubjectList();
	}

	@Override
	public List<ClassLevel> getClassLevelList() {
		return attendanceDao.getClassLevelList();
	}

	@Override
	public List<Section> getSectionList() {
		return attendanceDao.getSectionList();
	}

	@Override
	public List<SubjectDTO> retrieveSubjectByclassLevelId(Long classLevelId,Long majorId) {
		return attendanceDao.getSubjectListByClassLevel(classLevelId ,majorId);
	}

	@Override
	public List<Section> retrieveSectionByclassLevelId(Long classLevelId) {
		return attendanceDao.getSectionListByClassLevel(classLevelId);
	}

	@Override
	public List<Major> getMajorList() {
		return attendanceDao.getMajorList();
	}

	@Override
	public List<AttendanceStudentDTO> getAttendanceStudentByMajorAndSection(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		String pattern = "yyyy-MM-dd";
		Date attDate=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			attDate = simpleDateFormat.parse(attDTO.getAttDateString());
			String date = simpleDateFormat.format(new Date());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attDTO.setDate(attDate);
		return attendanceDao.getAttendanceStudentByMajorAndSection(attDTO);
	}

	@Override
	public void saveAttendanceList(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		String pattern = "yyyy-MM-dd";
		Date attDate=new Date();
		Date curDate=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			attDate = simpleDateFormat.parse(attDTO.getAttDateString());
			String date = simpleDateFormat.format(new Date());
			curDate=simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(AttendanceStudentDTO att:attDTO.getAttStudentList()){
			if(att!=null && att.getStudentId()!=null){
				Attendance attend=new Attendance();
				if(att.getId()!=null){
					attend.setId(att.getId());					
				}
				attend.getStudent().setId(att.getStudentId());
				attend.getClassLevel().setId(attDTO.getClassLevelId());
				attend.getSection().setId(attDTO.getSectionId());
				attend.getSubject().setId(attDTO.getSubjectId());
				attend.setSubjectTime(attDTO.getSubjectTime());
				attend.setStatus(att.getStatus());
				attend.setDate(attDate);
				attend.setSysDate(curDate);
				if(att.getStatus()==true)
				attend.setAttCount(1);
				else
					attend.setAttCount(0);
				attend.getUser().setId(attDTO.getUserId());
				attendanceDao.saveAttendance(attend);
			}
			
		}
	}

	@Override
	public List<MonthDTO> getMonthList() {
		// TODO Auto-generated method stub
		 String[] months = new DateFormatSymbols().getMonths();
		 List<MonthDTO> monthList=new ArrayList<MonthDTO>();
		 int i=0;
		 for(String m : months){
			 i++;
			 MonthDTO mon=new MonthDTO();
			 mon.setMonth(i);
			 mon.setName(m);
			 monthList.add(mon);
		 }
		 return monthList;
	}

	@Override
	public List<AttMonthDTO> getAttMonthListByClassLevelAndSection(
			AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttMonthListByClassLevelAndSection(attDTO);
	}

	@Override
	public List<MonthDTO> getMonthListByFromTo(int from, int month) {
		// TODO Auto-generated method stub
		List<MonthDTO> monList=new ArrayList<MonthDTO>();
		for(MonthDTO m : getMonthList()){
			if(m.getMonth()>=from && m.getMonth()<=month){
				monList.add(m);
			}
		}
		return monList;
	}

	@Override
	public List<AttSemesterDTO> getAttListBySemester(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttListBySemester(attDTO, getMonthListByFromTo(attDTO.getFromMonth(),attDTO.getToMonth()));
	}

	@Override
	public List<AttSubjectDTO> getAttListBySubject(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttListBySubject(attDTO);
	}

	@Override
	public List<AttSubjectDTO> getAttListByMonth(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		return attendanceDao.getAttListByMonth(attDTO);
	}

	@Override
	public List<Integer> getDayListByMonth(int month) {
		// TODO Auto-generated method stub
		/*YearMonth ym = YearMonth.of(2013, Month.JANUARY);
	    LocalDate firstOfMonth = ym.atDay(1);
	    LocalDate firstOfFollowingMonth = ym.plusMonths(1).atDay(1);
	    firstOfMonth.datesUntil(firstOfFollowingMonth).forEach(System.out::println);
	    */
		Calendar cal = Calendar.getInstance();
	    int year=cal.get(Calendar.YEAR);
	    Calendar cal2 = new GregorianCalendar(year, month-1, 1); 
	    int dayOfMonth = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
	    List<Integer> dayList=new ArrayList<Integer>();
	    for(int m=1;m<=dayOfMonth;m++){
	    	dayList.add(m);
	    }
	    return dayList;
	}

	@Override
	public List<AttDateDTO> getAttListByDate(AttendanceDTO attDTO) {
		String pattern = "yyyy-MM-dd";
		Date attDate=new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			attDate = simpleDateFormat.parse(attDTO.getAttDateString());
			String date = simpleDateFormat.format(new Date());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		attDTO.setDate(attDate);
		return attendanceDao.getAttListByDate(attDTO);
	}

	
	

	/*@Override
	public List<AttendanceDTO> retrieveSubjectByclassLevelId(Long classLevelId,
			Long majorId, Long subjectId) {
		return attendanceDao.getSubjectByClassLevel(classLevelId ,majorId,subjectId);
	}
*/
	/*@Override
	public List<SubjectDTO> retrieveSubjectBymajorId(Long majorId,
			Long subjectId) {
		// TODO Auto-generated method stub
		return attendanceDao.getSubjectBymajorId(majorId, subjectId);
	}*/

}
