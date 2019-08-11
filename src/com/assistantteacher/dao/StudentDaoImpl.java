package com.assistantteacher.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.AdminRole;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
@Repository
public class StudentDaoImpl extends GenericDaoImpl<Long, Student> implements StudentDao{

	@Override
	public void saveStudent(Student student) {
		getCurrentSession().saveOrUpdate(student);
	}

	@Override
	public List<StudentDTO> getStudentList() {
		Criteria c=getCurrentSession().createCriteria(Student.class)
				.createAlias("classLevel", "c",JoinType.LEFT_OUTER_JOIN)
				.createAlias("user", "u",JoinType.LEFT_OUTER_JOIN)
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN)
				.createAlias("major", "m",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("rollNo"),"rollNo")
				.add(Projections.property("nrc"),"nrc")
				.add(Projections.property("address"),"address")
				.add(Projections.property("dob"), "dob")
				.add(Projections.property("phone"), "phone")
				.add(Projections.property("email"), "email")
				.add(Projections.property("password"), "password")
				.add(Projections.property("runningYear"), "runningYear")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("imagepath"), "imagepath")
				.add(Projections.property("nationality"),"nationality")
				.add(Projections.property("religion"),"religion")
				.add(Projections.property("citizen"),"citizen")
				.add(Projections.property("c.id"),"classLevelId")
			    .add(Projections.property("c.name"),"classLevelName")
				.add(Projections.property("s.id"),"sectionId")
				.add(Projections.property("s.name"),"sectionName")
				.add(Projections.property("m.id"),"majorId")
				.add(Projections.property("m.name"),"majorName")
				.add(Projections.property("u.id"),"userId")
				.add(Projections.property("u.userName"),"userName")
				
				);
c.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
return c.list();
	}

	@Override
	public Boolean deleteStudent(long id) {
		getCurrentSession().createSQLQuery("Delete From Student Where id=:id").setParameter("id", id)
		.executeUpdate();
		return true;
	}

	@Override
	public List<StudentDTO> getClassLevelList() {
		return getCurrentSession().createCriteria(ClassLevel.class).list();
	}

	@Override
	public List<StudentDTO> getMajorList() {
		return getCurrentSession().createCriteria(Major.class).list();
	}

	@Override
	public List<StudentDTO> getSectionList() {
		return getCurrentSession().createCriteria(Section.class).list();
	}

	@Override
	public List<StudentDTO> getAdminRoleList() {
		Criteria c=getCurrentSession().createCriteria(AdminRole.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"adminRoleId")
				.add(Projections.property("name"),"adminRoleName"));
c.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
return c.list();
	}

	@Override
	public StudentDTO getStudentById(long id) {


			Criteria c=getCurrentSession().createCriteria(Student.class)
					.createAlias("user", "u", JoinType.LEFT_OUTER_JOIN)
					.createAlias("classLevel", "c", JoinType.LEFT_OUTER_JOIN)
					.createAlias("section", "s", JoinType.LEFT_OUTER_JOIN)
					.createAlias("major", "m", JoinType.LEFT_OUTER_JOIN)
					;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("name"),"name")
					.add(Projections.property("rollNo"),"rollNo")
					.add(Projections.property("nrc"),"nrc")
					.add(Projections.property("address"),"address")
					.add(Projections.property("dob"), "dob")
					.add(Projections.property("phone"), "phone")
					.add(Projections.property("email"), "email")
					.add(Projections.property("password"), "password")
					.add(Projections.property("runningYear"), "runningYear")
					.add(Projections.property("gender"), "gender")
					.add(Projections.property("u.imagePath"), "imagepath")
					.add(Projections.property("nationality"),"nationality")
					.add(Projections.property("religion"),"religion")
					.add(Projections.property("citizen"),"citizen")
					.add(Projections.property("c.id"),"classLevelId")
				    //.add(Projections.property("c.name"),"classLevelName")
					.add(Projections.property("s.id"),"sectionId")
					//.add(Projections.property("s.name"),"sectionName")
					.add(Projections.property("m.id"),"majorId")
					//.add(Projections.property("m.name"),"majorName")
					.add(Projections.property("u.id"),"userId")
					//.add(Projections.property("u.userName"),"userName")
					
					);
			c.add(Restrictions.eq("id", id));
	c.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
	StudentDTO student = (StudentDTO)c.uniqueResult();
	
	return student;
	}

	
	

}
