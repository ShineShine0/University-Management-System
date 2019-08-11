package com.assistantteacher.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.DepartmentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.Department;
@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Long, Department>implements DepartmentDao{

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		getCurrentSession().save(department);
	}

	@Override
	public List<DepartmentDTO> getDepartmentList() {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Department.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				);
c.setResultTransformer(Transformers.aliasToBean(DepartmentDTO.class));
return c.list();
	}

	@Override
	public Boolean deleteDepartment(long id) {
		// TODO Auto-generated method stub
		getCurrentSession().createSQLQuery("Delete From Department Where id=:id").setParameter("id", id)
		.executeUpdate();
		return true;
	}

}
