package com.jobfinder.service;

import java.util.List;

public interface GenericService<E, K> {

	 public void add(E entity);
	 
	 public void saveOrUpdate(E entity) ;
	 
	 public void update(E entity) ;
	 
	 public void delete(E entity);
	 
	 public E find(K key);
	 
	 public List<E> getAll();
	 
}
