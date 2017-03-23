package com.jobfinder.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.service.GenericService;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {

	private GenericDAO<E, K> genericDAO;

	public GenericServiceImpl(GenericDAO<E, K> genericDAO) {
		this.genericDAO = genericDAO;
	}

	public GenericServiceImpl() {
	}

	@Override
	@Transactional
	public void add(E entity) {
		genericDAO.add(entity);
	}
	@Override
	@Transactional
	public void saveOrUpdate(E entity) {
		genericDAO.saveOrUpdate(entity);
	}
	@Override
	@Transactional
	public void update(E entity) {
		genericDAO.update(entity);
	}
	@Override
	@Transactional
	public void delete(E entity) {
		genericDAO.delete(entity);
	}
	@Override
	@Transactional(readOnly = true)
	public E find(K key) {
		return genericDAO.find(key);
	}
	@Override
	@Transactional(readOnly = true)
	public List<E> getAll() {
		return genericDAO.getAll();
	}
}
