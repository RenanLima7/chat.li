package com.chatly.common;

import java.util.Optional;

public interface BaseService <E>{
	
	public Iterable<E> getAll();
	
	public E save(E entity);
			
	public void delete(E entity);
	
	public Optional<E> getById(Long id);
}
