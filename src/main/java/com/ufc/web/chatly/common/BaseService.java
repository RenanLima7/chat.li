package com.ufc.web.chatly.common;

import java.util.Optional;
import java.util.UUID;

public interface BaseService <E>{
	
	public Iterable<E> getAll();
	
	public E save(E entity);
			
	public void delete(E entity);
	
	public Optional<E> getById(UUID id);
}
