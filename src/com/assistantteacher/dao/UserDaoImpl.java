package com.assistantteacher.dao;

import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import sun.security.util.Password;

import com.assistantteacher.entity.Activity;
import com.assistantteacher.entity.Admin;
import com.assistantteacher.entity.Student;
import com.assistantteacher.entity.Subject;
import com.assistantteacher.entity.UserInfo;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Admin, Long> implements UserDao{
	
	@Override
	public UserInfo adminAuthenticate(String email, String password) {
			Criteria c2=getCurrentSession().createCriteria(UserInfo.class)
					.createAlias("role", "r",JoinType.LEFT_OUTER_JOIN)
					.createAlias("r.priviligesList", "p",JoinType.LEFT_OUTER_JOIN);
			
			c2.add(Restrictions.eq("userName", email));
			c2.add(Restrictions.eq("password", password));	
			UserInfo admin_user = (UserInfo) c2.uniqueResult();
			return admin_user;
			
}

	@Override
	public boolean saveUserForResetPassword(User user) {
		getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public Long getUserCount() {
		Criteria cri = getCurrentSession().createCriteria(UserInfo.class);
				cri.setProjection(Projections.rowCount());
		return (Long) cri.uniqueResult();
	}

	@Override
	public Long getStudentCount() {
		
		Criteria cri = getCurrentSession().createCriteria(Student.class);
		cri.setProjection(Projections.rowCount());
                return (Long) cri.uniqueResult();
	}

	@Override
	public Long getSubjectCount() {
		Criteria cri = getCurrentSession().createCriteria(Subject.class);
		cri.setProjection(Projections.rowCount());
                return (Long) cri.uniqueResult();
	}

	@Override
	public Long getAdminCount() {
		Criteria cri = getCurrentSession().createCriteria(Admin.class);
		cri.setProjection(Projections.rowCount());
                return (Long) cri.uniqueResult();
	}

	@Override
	public Boolean checkUser(String email) {
		Boolean flag= false;
		Criteria c2=getCurrentSession().createCriteria(UserInfo.class);
		c2.add(Restrictions.eq("userName", email+".com"));
		UserInfo user = (UserInfo) c2.uniqueResult();
		if(user != null){
			flag = true;
		}else{
			flag = false;
		}
		return flag;
	}

	}
