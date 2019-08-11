package com.assistantteacher.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.assistantteacher.dto.AdminDTO;
import com.assistantteacher.dto.StudentDTO;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.AdminRole;

import javax.validation.ConstraintViolationException;

@Repository
public class AdminDaoImpl extends GenericDaoImpl<Long, Admin>implements AdminDao {

	@Override
	public void saveAdmin(Admin admin) {
		getCurrentSession().saveOrUpdate(admin);
	}

	@Override
	public List<AdminDTO> getAdminList() {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Admin.class)
				.createAlias("department", "d",JoinType.LEFT_OUTER_JOIN)
				.createAlias("user", "u",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("nrc"),"nrc")
				.add(Projections.property("address"),"address")
				.add(Projections.property("dob"), "dob")
				.add(Projections.property("mobileNumber"), "mobileNumber")
				.add(Projections.property("email"), "email")
				.add(Projections.property("password"), "password")
				.add(Projections.property("position"), "position")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("nationality"), "nationality")
				.add(Projections.property("d.id"), "departmentId")
				.add(Projections.property("d.name"), "departmentName")
				.add(Projections.property("u.id"),"userId")
				
				);
c.setResultTransformer(Transformers.aliasToBean(AdminDTO.class));
return c.list();
	}

	@Override
	public List<AdminDTO> getAdminRoleList() {
		Criteria c=getCurrentSession().createCriteria(AdminRole.class);
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"adminRoleId")
				.add(Projections.property("name"),"adminRoleName"));
c.setResultTransformer(Transformers.aliasToBean(AdminDTO.class));
return c.list();
	}

	@Override
	public String deleteAdmin(long id) throws org.hibernate.exception.ConstraintViolationException {
			String result = "false";
			try{
				SQLQuery q = getCurrentSession().createSQLQuery("Delete From Admin Where id=:id");
				q.setParameter("id", id);
				q.executeUpdate();
				result="true";
			}catch(ConstraintViolationException ce){
				ce.printStackTrace();
				result="false";
			}catch(org.hibernate.exception.ConstraintViolationException ce){
				result="false";
			}
			return result;
		}

	@Override
	public AdminDTO getAdminById(long id) {
		Criteria c=getCurrentSession().createCriteria(Admin.class)
				.createAlias("department", "d", JoinType.LEFT_OUTER_JOIN)
				.createAlias("user","u",JoinType.LEFT_OUTER_JOIN);
				
		c.setProjection(Projections.projectionList()
				.add(Projections.property("id"),"id")
				.add(Projections.property("name"),"name")
				.add(Projections.property("nrc"),"nrc")
				.add(Projections.property("address"),"address")
				.add(Projections.property("dob"), "dob")
				.add(Projections.property("mobileNumber"), "mobileNumber")
				.add(Projections.property("email"), "email")
				.add(Projections.property("password"), "password")
				.add(Projections.property("position"), "position")
				.add(Projections.property("gender"), "gender")
				.add(Projections.property("nationality"), "nationality")
				.add(Projections.property("d.name"), "departmentName")
				.add(Projections.property("d.id"), "departmentId")
				.add(Projections.property("u.role.id"), "adminRoleId")
				.add(Projections.property("u.id"),"userId")
				);
		
		c.add(Restrictions.eq("id",id));
		c.setResultTransformer(Transformers.aliasToBean(AdminDTO.class));
		AdminDTO admin=(AdminDTO)c.uniqueResult();
		return admin;
		
	}
		
}
