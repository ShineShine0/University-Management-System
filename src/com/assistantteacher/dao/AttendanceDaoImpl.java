package com.assistantteacher.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

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
import com.assistantteacher.entity.Student;
import com.assistantteacher.entity.Subject;



@Repository
public class AttendanceDaoImpl extends GenericDaoImpl<Attendance, Long>implements AttendanceDao {

	@Override
	public List<Subject> getSubjectList() {
		Criteria c=getCurrentSession().createCriteria(Subject.class)
				.setProjection(Projections.projectionList()	
					      .add(Projections.property("id"), "id")
					      .add(Projections.property("name"), "name")
				);
		c.setResultTransformer(Transformers.aliasToBean(Subject.class));
		return c.list();
	}

	@Override
	public List<ClassLevel> getClassLevelList() {
		Criteria c=getCurrentSession().createCriteria(ClassLevel.class)
				.setProjection(Projections.projectionList()	
					      .add(Projections.property("id"), "id")
					      .add(Projections.property("name"), "name")
				);
		c.setResultTransformer(Transformers.aliasToBean(ClassLevel.class));
		return c.list();
	}

	@Override
	public List<Section> getSectionList() {
		Criteria c=getCurrentSession().createCriteria(Section.class)
				.setProjection(Projections.projectionList()	
					      .add(Projections.property("id"), "id")
					      .add(Projections.property("name"), "name")
				);
		c.setResultTransformer(Transformers.aliasToBean(Section.class));
		return c.list();
	}

	@Override
	public List<SubjectDTO> getSubjectListByClassLevel(Long classLevelId ,Long majorId) {
		Criteria c=getCurrentSession().createCriteria(Subject.class)
				.createAlias("classLevel", "cl",JoinType.LEFT_OUTER_JOIN)
				.createAlias("majorList", "ml",JoinType.LEFT_OUTER_JOIN)
				.createAlias("teacher", "t",JoinType.LEFT_OUTER_JOIN);
	
		         c.setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")
							      .add(Projections.property("name"), "name")
						);
				c.add(Restrictions.eq("classLevel.id", classLevelId));
				//c.add(Restrictions.eq("ml.id", majorId));
				c.setResultTransformer(Transformers.aliasToBean(SubjectDTO.class));
				List<SubjectDTO>  list = c.list();
				
				String sql="select s.Id,s.name from Subject s "
						+ "JOIN subject_major sm  ON s.Id=sm.subjectId "
						+ "JOIN classlevel cl ON cl.Id=s.ClassLevelId "
						+ "JOIN major m ON m.Id=sm.majorId where cl.Id=:classLevel and m.Id=:majorId";
				
				
				
				SQLQuery query = getCurrentSession().createSQLQuery(sql);
				query.setParameter("classLevel", classLevelId);
				query.setParameter("majorId", majorId);
				query.addScalar("id",StandardBasicTypes.LONG);
				query.addScalar("name",StandardBasicTypes.STRING);
				query.setResultTransformer(Transformers.aliasToBean(SubjectDTO.class));
				return query.list();
	}

	@Override
	public List<Section> getSectionListByClassLevel(Long classLevelId) {
		Criteria c=getCurrentSession().createCriteria(Section.class)
		         .setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")
							      .add(Projections.property("name"), "name")
						);
				c.add(Restrictions.eq("classLevel.id", classLevelId));
				c.setResultTransformer(Transformers.aliasToBean(Section.class));
				return c.list();
	}

	@Override
	public List<Major> getMajorList() {
		Criteria c=getCurrentSession().createCriteria(Major.class)
				.setProjection(Projections.projectionList()	
					      .add(Projections.property("id"), "id")
					      .add(Projections.property("name"), "name")
				);
		c.setResultTransformer(Transformers.aliasToBean(Major.class));
		return c.list();
	}

	@Override
	public List<AttendanceStudentDTO> getAttendanceStudentByMajorAndSection(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Student.class)
			
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"studentId")
				.add(Projections.property("name"),"name")
				.add(Projections.property("rollNo"),"rollNo")
				/*
				.add(Projections.property("s.id"),"sectionId")
				.add(Projections.property("m.id"),"majorId")
				*/
				);
		c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
		c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
		c.setResultTransformer(Transformers.aliasToBean(AttendanceStudentDTO.class));
		List<AttendanceStudentDTO> stdList=c.list();
		for(AttendanceStudentDTO std : stdList){
			Criteria catt=getCurrentSession().createCriteria(Attendance.class);
			catt.add(Restrictions.eq("subject.id", attDTO.getSubjectId()));
			catt.add(Restrictions.eq("section.id", attDTO.getSectionId()));
			catt.add(Restrictions.eq("student.id",std.getStudentId()));
			catt.add(Restrictions.eq("date",attDTO.getDate()));
			catt.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("status"),"status")
				);
			catt.setResultTransformer(Transformers.aliasToBean(Attendance.class));
			Attendance att=(Attendance)catt.uniqueResult();
			if(att!=null){
				std.setStatus(att.getStatus());
				std.setId(att.getId());
			}else{
				std.setStatus(true);
			}
			
		}
		return stdList;
	}

	@Override
	public void saveAttendance(Attendance att) {
		// TODO Auto-generated method stub
		getCurrentSession().saveOrUpdate(att);
	}

	@Override
	public List<AttMonthDTO> getAttMonthListByClassLevelAndSection(
			AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Student.class)
				
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"studentId")
				.add(Projections.property("name"),"name")
				.add(Projections.property("rollNo"),"rollNo")
				/*
				.add(Projections.property("s.id"),"sectionId")
				.add(Projections.property("m.id"),"majorId")
				*/
				);
		c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
		if(attDTO.getMajorId()!=null){
			c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
		}
		
		c.setResultTransformer(Transformers.aliasToBean(AttMonthDTO.class));
		List<AttMonthDTO> stdList=c.list();
		for(AttMonthDTO std : stdList){
			SQLQuery sql=getCurrentSession().createSQLQuery("SELECT SUM(a.AttCount*a.SubjectTime) as totalCount FROM attendance a where month(a.date)=:Month and a.StudentId=:StdId");
			sql.setParameter("Month", attDTO.getMonth());
			sql.setParameter("StdId", std.getStudentId());
			//sql.setResultTransformer(Transformers.aliasToBean(Double.class));
			double count=(Double)sql.uniqueResult();
			std.setTotalCount(count);
		}
		
		return stdList;
	}

	@Override
	public List<AttendanceDTO> getSubjectByClassLevel(Long classLevelId,
			Long majorId, Long subjectId) {
		
		Criteria c=getCurrentSession().createCriteria(Attendance.class)
				.createAlias("classLevel", "cl",JoinType.LEFT_OUTER_JOIN)
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				//.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN)
				.createAlias("subject", "sb",JoinType.LEFT_OUTER_JOIN)
		        .createAlias("student", "st",JoinType.LEFT_OUTER_JOIN);
		         c.setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")							     							      
								  .add(Projections.property("st.rollNo"),"rollNo")
								  .add(Projections.property("st.name"),"name")
								  .add(Projections.property("sb.name"),"subjectName")
						);
		            
				    c.add(Restrictions.eq("cl.id", classLevelId));
				    //c.add(Restrictions.eq("m.id", majorId));
				    c.add(Restrictions.eq("s.id", subjectId));
			
				c.setResultTransformer(Transformers.aliasToBean(AttendanceDTO.class));
				return c.list();
	}

	
	public List<AttSemesterDTO> getAttListBySemester(AttendanceDTO attDTO,List<MonthDTO> monList) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Student.class)
				
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"studentId")
				.add(Projections.property("name"),"name")
				.add(Projections.property("rollNo"),"rollNo")
				/*
				.add(Projections.property("s.id"),"sectionId")
				.add(Projections.property("m.id"),"majorId")
				*/
				);
		c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
		if(attDTO.getMajorId()!=null){
			c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
		}
		
		c.setResultTransformer(Transformers.aliasToBean(AttSemesterDTO.class));
		List<AttSemesterDTO> stdList=c.list();
		for(AttSemesterDTO att : stdList){
			att.setAttCountList(getAttendanceListByMonth(att.getStudentId(),attDTO.getClassLevelId(),monList));
			double totalCount = att.getAttCountList().stream().mapToDouble(f -> f.doubleValue()).sum();
			att.setTotalCount(totalCount);
		}
		return stdList;
	}

	@Override
	public List<Double> getAttendanceListByMonth(Long stdId, Long classLevelId,
			List<MonthDTO> monthList) {
		// TODO Auto-generated method stub
		List<Double >attList=new ArrayList<Double>();
		for(MonthDTO mon : monthList){
			SQLQuery sql=getCurrentSession().createSQLQuery("SELECT COALESCE(SUM(a.AttCount*a.SubjectTime),0) as totalCount FROM attendance a where month(a.date)=:Month and a.StudentId=:StdId and a.ClassLevelId=:classLevelId");
			sql.setParameter("Month", mon.getMonth());
			sql.setParameter("StdId", stdId);
			sql.setParameter("classLevelId", classLevelId);
			//sql.setResultTransformer(Transformers.aliasToBean(Double.class));
			double count=(Double)sql.uniqueResult();
			attList.add(count);
		}
		return attList;
	}

	@Override
	public List<Double> getAttendanceListBySubject(Long stdId,
		Long classLevelId, int month,List<SubjectDTO> subjectList) {
		
		List<Double >attList=new ArrayList<Double>();
		for(SubjectDTO sub : subjectList){
			SQLQuery sql=getCurrentSession().createSQLQuery("SELECT COALESCE(SUM(a.AttCount*a.SubjectTime),0) as totalCount FROM attendance a where month(a.date)=:Month and a.subjectId=:SubjectId and a.StudentId=:StdId and a.ClassLevelId=:classLevelId");
			sql.setParameter("Month", month);
			sql.setParameter("StdId", stdId);
			sql.setParameter("classLevelId", classLevelId);
			sql.setParameter("SubjectId", sub.getId());
			//sql.setResultTransformer(Transformers.aliasToBean(Double.class));
			double count=(Double)sql.uniqueResult();
			attList.add(count);
		}
		return attList;
	}

	@Override
	public List<AttSubjectDTO> getAttListBySubject(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
Criteria c=getCurrentSession().createCriteria(Student.class)
				
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"studentId")
				.add(Projections.property("name"),"name")
				.add(Projections.property("rollNo"),"rollNo")
				/*
				.add(Projections.property("s.id"),"sectionId")
				.add(Projections.property("m.id"),"majorId")
				*/
				);
		c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
		if(attDTO.getMajorId()!=null){
			c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
		}
		
		c.setResultTransformer(Transformers.aliasToBean(AttSubjectDTO.class));
		List<AttSubjectDTO> stdList=c.list();
		List<SubjectDTO> subjectList=getSubjectListByClassLevel(attDTO.getClassLevelId(), attDTO.getMajorId());
		for(AttSubjectDTO att : stdList){
			att.setAttCountList(getAttendanceListBySubject(att.getStudentId(), attDTO.getClassLevelId(), attDTO.getMonth(), subjectList));
			double totalCount = att.getAttCountList().stream().mapToDouble(f -> f.doubleValue()).sum();
			att.setTotalCount(totalCount);
		}
		return stdList;
	}

	@Override
	public List<AttSubjectDTO> getAttListByMonth(AttendanceDTO attDTO) {
		// TODO Auto-generated method stub
		 
		    
		    Criteria c=getCurrentSession().createCriteria(Student.class)
					
					.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
					.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"studentId")
					.add(Projections.property("name"),"name")
					.add(Projections.property("rollNo"),"rollNo")
					/*
					.add(Projections.property("s.id"),"sectionId")
					.add(Projections.property("m.id"),"majorId")
					*/
					);
			c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
			if(attDTO.getMajorId()!=null){
				c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
			}
			
			c.setResultTransformer(Transformers.aliasToBean(AttSubjectDTO.class));
			List<AttSubjectDTO> stdList=c.list();
			for(AttSubjectDTO att : stdList){
				att.setAttCountList(getAttListByDate(att.getStudentId(), attDTO.getClassLevelId(), attDTO.getMonth()));
				double totalCount = att.getAttCountList().stream().mapToDouble(f -> f.doubleValue()).sum();				
				att.setTotalCount(totalCount);
			}
		return stdList;
	}
		private List<Double> getAttListByDate(Long stdId,Long classLevelId,int month){
			
			Calendar cal = Calendar.getInstance();
		    int year=cal.get(Calendar.YEAR);
		    Calendar cal2 = new GregorianCalendar(year, month-1, 1); 
		    int dayOfMonth = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
			List<Double>attList=new ArrayList<Double>();
			for(int i=1;i<=dayOfMonth;i++){
				SQLQuery sql=getCurrentSession().createSQLQuery("SELECT COALESCE(SUM(a.AttCount*a.SubjectTime),0) as totalCount FROM attendance a where day(a.date)=:Day and month(a.date)=:Month and a.StudentId=:StdId and a.ClassLevelId=:classLevelId");
				sql.setParameter("Day", i);
				sql.setParameter("Month", month);
				sql.setParameter("StdId", stdId);
				sql.setParameter("classLevelId", classLevelId);
				//sql.setResultTransformer(Transformers.aliasToBean(Double.class));
				double count=(Double)sql.uniqueResult();
				attList.add(count);
			}
			return attList;
		}

		@Override
		public List<AttDateDTO> getAttListByDate(AttendanceDTO attDTO) {
			Criteria c=getCurrentSession().createCriteria(Student.class)
					
					.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
					.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN);
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"studentId")
					.add(Projections.property("name"),"name")
					.add(Projections.property("rollNo"),"rollNo")
					
					);
			c.add(Restrictions.eq("s.id",attDTO.getSectionId()));
			if(attDTO.getMajorId()!=null){
				c.add(Restrictions.eq("m.id",attDTO.getMajorId()));
			}
			
			c.setResultTransformer(Transformers.aliasToBean(AttDateDTO.class));
			List<AttDateDTO> stdList=c.list();
			List<SubjectDTO> subjectList=getSubjectListByClassLevel(attDTO.getClassLevelId(), attDTO.getMajorId());
			for(AttDateDTO att : stdList){
				att.setAttCountList(getAttendanceListByDate(att.getStudentId(), attDTO.getClassLevelId(), attDTO.getDate(), subjectList));
				double totalCount = att.getAttCountList().stream().mapToDouble(f -> f.doubleValue()).sum();
				att.setTotalCount(totalCount);
			}
			return stdList;
			
		}


		private List<Double> getAttendanceListByDate(Long studentId,
				Long classLevelId, Date date, List<SubjectDTO> subjectList) {
	
		   
			List<Double>attList=new ArrayList<Double>();
			for(SubjectDTO sub : subjectList){
				SQLQuery sql=getCurrentSession().createSQLQuery("SELECT COALESCE(SUM(a.AttCount*a.SubjectTime),0) as totalCount FROM attendance a where a.date =:date  and  a.subjectId=:SubjectId and a.StudentId=:StdId and a.ClassLevelId=:classLevelId");
				sql.setParameter("date", date);
			    sql.setParameter("StdId", studentId);
				sql.setParameter("classLevelId", classLevelId);
				sql.setParameter("SubjectId", sub.getId());
				//sql.setResultTransformer(Transformers.aliasToBean(Double.class));
				double count=(Double)sql.uniqueResult();
				attList.add(count);
			
			}
				
			
			return attList;
		}

		
	

}
