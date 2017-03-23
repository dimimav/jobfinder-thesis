package com.jobfinder.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobfinder.dao.GenericDAO;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDAOImpl<E,K extends Serializable> implements GenericDAO<E, K> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    protected Class<? extends E> daoType;

	
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	protected Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}
	
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    /**
     * By defining this class as abstract, we prevent Spring from creating instance of this class
     * If not defined abstract getClass().getGenericSuperClass() would return Object.
     * There would be exception because Object class does not hava constructor with parameters.
     */
    public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
    
    @Override
    public void add(E entity) {
    	getSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(E entity) {
    	getSession().saveOrUpdate(entity);
    }
     
    @Override
    public void update(E entity) {
    	getSession().merge(entity);
    }
   
    @Override
    public E find(K key) {
        return (E) getSession().get(daoType, (Serializable) key);
    }

    @Override
    public List<E> getAll(){
    	 return getSession().createCriteria(daoType).list();
    }

	public void delete(E entity){
		getSession().delete(entity);
	}

}
