package com.jobfinder.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jobfinder.dao.UserDAO;
import com.jobfinder.model.User;
@Repository
public class UserDAOImpl extends GenericDAOImpl<User,Integer> implements UserDAO{
	
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public User findByUsername(String uname) {
		logger.debug("findByUsername: "+uname);
		String hql = "from User where username = :uname";
		Query query = getSession().createQuery(hql);
		query.setParameter("uname",uname);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public User save(User user) {
		// save Entity and get the generated id
		int generatedId = (int) getSession().save(user);
		//return generated entity
		return find(generatedId);
	}

}
