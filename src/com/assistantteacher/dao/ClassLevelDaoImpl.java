package com.assistantteacher.dao;

import java.util.List;











import javax.validation.ConstraintViolationException;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.ClassLevelDTO;
import com.assistantteacher.dto.SectionDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Major;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Subject;

@Repository
public class ClassLevelDaoImpl extends  GenericDaoImpl<Long,ClassLevel> implements ClassLevelDao{

	@Override
	public void save(ClassLevel classLevel) {
		getCurrentSession().saveOrUpdate(classLevel);
	}

	@Override
	public List<ClassLevel> retrieve() {
		Criteria c2=getCurrentSession().createCriteria(ClassLevel.class);
		List<ClassLevel> years = (List<ClassLevel>) c2.list();
		return years;
	}

	@Override
	public void update(ClassLevelDTO classLevel) {
		getCurrentSession().createSQLQuery("Update ClassLevel set name=:name where id=:id")
		.setParameter("name",classLevel.getName())
		.setParameter("id", classLevel.getId())
		.executeUpdate();
	}

	@Override
	public ClassLevelDTO getClassLevelById(long id) {
		Criteria c=getCurrentSession().createCriteria(ClassLevel.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				);
		c.add(Restrictions.eq("id", id));
		c.setResultTransformer(Transformers.aliasToBean(ClassLevelDTO.class));
		return (ClassLevelDTO)c.uniqueResult();
	}

	@Override
	public Boolean delete(long id) {

		Criteria cr=getCurrentSession().createCriteria(ClassLevel.class)
				.createAlias("section", "s",JoinType.LEFT_OUTER_JOIN);
		cr.add(Restrictions.eq("s.id", id));
		
		List<ClassLevel> rlist=cr.list();
		
		if(rlist.size() == 0) {
			
			Criteria c=getCurrentSession().createCriteria(Section.class);
			c.add(Restrictions.eq("id", id));
			Section s=(Section)c.uniqueResult();
			getCurrentSession().delete(s);
			getCurrentSession().flush();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Boolean deleteSection(long id) {
		Criteria c=getCurrentSession().createCriteria(Section.class);
		c.add(Restrictions.eq("id", id));
		Section s=(Section)c.uniqueResult();
		getCurrentSession().delete(s);
		getCurrentSession().flush();
		
		return true;
	}

	@Override
	public List<Admin> retrieveAdminList() {
		Criteria c2=getCurrentSession().createCriteria(Admin.class);
		List<Admin> t = (List<Admin>) c2.list();
		return t;
	}

	@Override
	public void saveSection(Section section) {
		getCurrentSession().saveOrUpdate(section);
		
	}

	@Override
	public List<Section> retrieveSection() {

		Criteria c2=getCurrentSession().createCriteria(Section.class);
		List<Section> t = (List<Section>) c2.list();
		return t;
	}

	@Override
	public List<ClassLevelDTO> getMajorList() {
		Criteria c=getCurrentSession().createCriteria(Major.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				);
		c.setResultTransformer(Transformers.aliasToBean(ClassLevelDTO.class));
		return c.list();
	}

	@Override
	public Boolean deleteClassLevel(long id) {
		Boolean result = false;
		try{
			SQLQuery q = getCurrentSession().createSQLQuery("Delete From ClassLevel Where id=:id");
			q.setParameter("id", id);
			q.executeUpdate();
			result=true;
		}catch(ConstraintViolationException ce){
			ce.printStackTrace();
			result=false;
		}catch(org.hibernate.exception.ConstraintViolationException ce){
			result=false;
		}
		return result;
	}

	@Override
	public SectionDTO getSectionById(long id) {
		Criteria c=getCurrentSession().createCriteria(Section.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				);
		c.add(Restrictions.eq("id", id));
		c.setResultTransformer(Transformers.aliasToBean(SectionDTO.class));
		return (SectionDTO)c.uniqueResult();
	}

	@Override
	public void update(SectionDTO section) {
		getCurrentSession().createSQLQuery("Update Section set name=:name where id=:id")
		.setParameter("name",section.getName())
		.setParameter("id", section.getId())
		.executeUpdate();
		
	}

	@Override
	public void saveSubject(Subject subject) {
	    getCurrentSession().saveOrUpdate(subject);	
		
	}

	@Override
	public List<SubjectDTO> retrieveSubject() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT sub.id as id, sub.name as name,admin.name as teacherName,class.name as classLevelName,major.name as majorName");
		sb.append(" FROM Subject sub");
		sb.append(" inner join subject_teacher st on st.subjectId = sub.id");
		sb.append(" inner join admin admin on admin.id = st.teacherId");
		sb.append(" inner join subject_major sm on sm.subjectId= sub.id");
		sb.append(" inner join major major on major.id = sm.majorId");
		sb.append(" left join ClassLevel class on class.id = sub.classLevelId");
		//sb.append(" where se.id=:sectionId and st.year=:year");
		//sb.append(" group by s.name");
		//sb.append(" order by sub.rollNo");
		
		SQLQuery query=getCurrentSession().createSQLQuery(sb.toString());
		query.addScalar("id",StandardBasicTypes.LONG);
		query.addScalar("name",StandardBasicTypes.STRING);
		query.addScalar("teacherName",StandardBasicTypes.STRING);
		query.addScalar("classLevelName",StandardBasicTypes.STRING);
		query.addScalar("majorName",StandardBasicTypes.STRING);
		query.setResultTransformer(Transformers.aliasToBean(SubjectDTO.class));
		return query.list();
	}

	
}
