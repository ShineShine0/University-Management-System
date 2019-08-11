
package com.assistantteacher.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
@Repository
public class ActivityDaoImpl extends GenericDaoImpl<Activity,Long>implements ActivityDao {
	@Override
	public List<ClassLevel>getClassLevelList(){
		Criteria c=getCurrentSession().createCriteria(ClassLevel.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"),"id")
						.add(Projections.property("name"),"name")
						);
					c.setResultTransformer(Transformers.aliasToBean(ClassLevel.class));
					return c.list();
	}
	@Override
	public List<Section>getSectionList(){
		Criteria c=getCurrentSession().createCriteria(Section.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"),"id")
						.add(Projections.property("name"),"name"));
					c.setResultTransformer(Transformers.aliasToBean(Section.class));
					return c.list();
						
	}
	@Override
	public List<Section> getSectionListByClassLevel(long classLevelId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Section.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"),"id")
						.add(Projections.property("name"),"name"));
		c.add(Restrictions.eq("classLevel.id", classLevelId));
					c.setResultTransformer(Transformers.aliasToBean(Section.class));
					return c.list();
	}
	@Override
	public String getTeacherName(Long id) {
		Criteria c=getCurrentSession().createCriteria(Admin.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("name"),"name"));
		c.add(Restrictions.eq("id", id));
		return (String) c.uniqueResult();
	}
	
	@Override
	public List<Student> getStudentList(long classLevelId, long sectionId) {
		Criteria c=getCurrentSession().createCriteria(Student.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"),"id")
						.add(Projections.property("name"),"name")
						.add(Projections.property("rollNo"),"rollNo")
						.add(Projections.property("email"),"email"));
		c.add(Restrictions.eq("classLevel.id", classLevelId));
		c.add(Restrictions.eq("section.id", classLevelId));
		c.setResultTransformer(Transformers.aliasToBean(Student.class));
		return c.list();
	}
	@Override
	public void saveActivity(Activity activity) {
		getCurrentSession().saveOrUpdate(activity);
	}
	@Override
	public List<Activity> getActivityListByUserId(long userId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Activity.class);
		c.add(Restrictions.eq("teacher.id", userId));
		c.addOrder(Order.desc("date"));
		return c.list();
	}



}
