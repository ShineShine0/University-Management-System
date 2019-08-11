package com.assistantteacher.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.DocumentDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.ClassLevel;
import com.assistantteacher.entity.Document;
import com.assistantteacher.entity.Section;
import com.assistantteacher.entity.Student;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.entity.UserInfo;
import com.assistantteacher.util.SecurityUtil;

@Repository
public class DocumentDaoImpl extends GenericDaoImpl<Document, Long> implements DocumentDao{

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
	public List<Subject> getSubjectListByClassLevel(Long classLevelId) {
		Criteria c=getCurrentSession().createCriteria(Subject.class)
         .setProjection(Projections.projectionList()	
					      .add(Projections.property("id"), "id")
					      .add(Projections.property("name"), "name")
				);
		c.add(Restrictions.eq("classLevel.id", classLevelId));
		c.setResultTransformer(Transformers.aliasToBean(Subject.class));
		return c.list();
	}
	@Override
	public List<Section> getSectionListByClassLevel(Long classLevelId) {
		// TODO Auto-generated method stub
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
	public void saveDocument(Document d) {
		getCurrentSession().saveOrUpdate(d);
	}
	@Override
	public List<DocumentDTO> getDocumentListByUser(Long userId) {
		Criteria c=getCurrentSession().createCriteria(UserInfo.class)
		         .setProjection(Projections.projectionList()	
							      .add(Projections.property("position"), "position")
							      );
		c.add(Restrictions.eq("id", userId));
		String position = (String) c.uniqueResult();
		StudentDTO d2 = null;
		System.out.println("\n\n\n\n >>>>>>>   position"+position);
		if(position.equals("student")){
			System.out.println("in if>>>>>>>>>");
			Criteria c2=getCurrentSession().createCriteria(Student.class)
					.createAlias("user", "u" , JoinType.LEFT_OUTER_JOIN)
					.createAlias("classLevel", "c" , JoinType.LEFT_OUTER_JOIN)
					.createAlias("section", "s" , JoinType.LEFT_OUTER_JOIN)
			        .setProjection(Projections.projectionList()	
								      .add(Projections.property("s.id"), "sectionId")
								      .add(Projections.property("c.id"), "classLevelId")
								      );
			c2.add(Restrictions.eq("u.id", userId));
			c2.setResultTransformer(Transformers.aliasToBean(StudentDTO.class));
			d2 = (StudentDTO) c2.uniqueResult();
		
		Criteria c3=getCurrentSession().createCriteria(Document.class)
				.createAlias("classLevel", "c" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("section", "s" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("user", "u" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("subject", "su" , JoinType.LEFT_OUTER_JOIN)
		         .setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")
							      .add(Projections.property("date"), "date")
							      .add(Projections.property("title"), "title")
							      .add(Projections.property("su.name"), "subjectName")
							     .add(Projections.property("u.userName"), "teacherName")
							     .add(Projections.property("name"), "name")
							      );
		c3.add(Restrictions.eq("s.id", d2.getSectionId()));
		c3.add(Restrictions.eq("c.id", d2.getClassLevelId()));
		c3.setResultTransformer(Transformers.aliasToBean(DocumentDTO.class));
		return c3.list();
		}else{
			Criteria c3=getCurrentSession().createCriteria(Document.class)
					.createAlias("classLevel", "c" , JoinType.LEFT_OUTER_JOIN)
					.createAlias("section", "s" , JoinType.LEFT_OUTER_JOIN)
					.createAlias("user", "u" , JoinType.LEFT_OUTER_JOIN)
					.createAlias("subject", "su" , JoinType.LEFT_OUTER_JOIN)
			         .setProjection(Projections.projectionList()	
								      .add(Projections.property("id"), "id")
								      .add(Projections.property("date"), "date")
								      .add(Projections.property("title"), "title")
								      .add(Projections.property("su.name"), "subjectName")
								     .add(Projections.property("u.userName"), "teacherName")
								     .add(Projections.property("name"), "name")
								      );
			//c3.add(Restrictions.eq("s.id", d2.getSectionId()));
			c3.add(Restrictions.eq("u.id", SecurityUtil.getCurrentLoginAdminUser().getId()));
			c3.setResultTransformer(Transformers.aliasToBean(DocumentDTO.class));
			return c3.list();
		}
	}
	
	public DocumentDTO getDocumentListById(long id){
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Document.class)
				.createAlias("classLevel", "c" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("section", "s" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("subject", "su" , JoinType.LEFT_OUTER_JOIN)
		         .setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")
							      .add(Projections.property("date"), "date")
							      .add(Projections.property("title"), "title")
							      .add(Projections.property("dataPath"), "dataPath")
							      .add(Projections.property("imagePath"), "imagePath")
							      .add(Projections.property("name"), "name")
							      .add(Projections.property("su.id"), "subjectId")
							      .add(Projections.property("s.id"), "sectionId")
							      .add(Projections.property("c.id"), "classLevelId")
						);
				c.add(Restrictions.eq("id", id));
				c.setResultTransformer(Transformers.aliasToBean(DocumentDTO.class));
				DocumentDTO document= (DocumentDTO)c.uniqueResult();
				System.out.println(document.getTitle()+"<<title"+document.getSectionId()+"<<section"+document.getSubjectId()+"<<subject");
				return document;
	}
	@Override
	public List<DocumentDTO> getDocumentListByTeacherId(Long userId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Document.class)
				.createAlias("user", "u" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("classLevel", "c" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("section", "s" , JoinType.LEFT_OUTER_JOIN)
				.createAlias("subject", "su" , JoinType.LEFT_OUTER_JOIN)
		         .setProjection(Projections.projectionList()	
							      .add(Projections.property("id"), "id")
							      .add(Projections.property("date"), "date")
							      .add(Projections.property("title"), "title")
							      .add(Projections.property("name"), "name")
							      .add(Projections.property("u.userName"), "teacherName")
							      .add(Projections.property("su.name"), "subjectName")
							      .add(Projections.property("s.name"), "sectionName")
							      .add(Projections.property("c.name"), "classLevelName")
							);
					c.add(Restrictions.eq("u.id", userId));
					c.setResultTransformer(Transformers.aliasToBean(DocumentDTO.class));
					return c.list();
	}
	@Override
	public Boolean delete(long id) {
		Boolean result=false;
		try{
			SQLQuery q=getCurrentSession().createSQLQuery("Delete From Document Where id =:id");
			q.setParameter("id", id);
			q.executeUpdate();
			result=true;
		}catch(ConstraintViolationException ce){
			ce.printStackTrace();
			result=false;
		}
		return result;
	}
	

}