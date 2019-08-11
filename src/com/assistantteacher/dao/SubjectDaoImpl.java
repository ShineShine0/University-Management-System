package com.assistantteacher.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.BookDTO;
import com.assistantteacher.dto.SubjectDTO;
import com.assistantteacher.entity.Book;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Subject;

@Repository
public class SubjectDaoImpl extends GenericDaoImpl<Long, Subject> implements  SubjectDao{

	@Override
	public long save(Subject subject) {
		return (long)getCurrentSession().save(subject);
	}

	@Override
	public void updateSubject(Subject subject) {
		getCurrentSession().saveOrUpdate(subject);
		
	}

	@Override
	public boolean deleteSubject(long id) {
		try{
			Subject b=(Subject)getCurrentSession().get(Subject.class,id);
			getCurrentSession().delete(b);
			getCurrentSession().flush();
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	

	@Override
	public List<SubjectDTO> getSubjectList() {
		Criteria c=getCurrentSession().createCriteria(Subject.class)
				.createAlias("classlevel", "cl",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("cl.name"), "classLevelName")
				.add(Projections.property("cl.id"), "classLevelId")
				);
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return c.list();
	}

	@Override
	public SubjectDTO getSubjectById(long id) {
		Criteria c=getCurrentSession().createCriteria(Book.class)
				.createAlias("classlevel", "cl",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name")
				.add(Projections.property("cl.name"), "classLevelName")
				.add(Projections.property("cl.id"), "classLevelId")
				);
		c.add(Restrictions.eq("id", id));
		c.setResultTransformer(Transformers.aliasToBean(BookDTO.class));
		return (SubjectDTO)c.uniqueResult();
	}

	@Override
	public void saveSubject(Subject subject) {
		getCurrentSession().save(subject);
		
	}

	@Override
	public List<SubjectDTO> retrieveClassLevel() {
		Criteria c=getCurrentSession().createCriteria(ClassLevel.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"), "id")
				.add(Projections.property("name"), "name"));
		c.setResultTransformer(Transformers.aliasToBean(SubjectDTO.class));
		return c.list();
	}

}
