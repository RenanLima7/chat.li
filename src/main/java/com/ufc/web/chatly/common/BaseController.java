package com.ufc.web.chatly.common;

import org.springframework.http.ResponseEntity;

public interface BaseController <E, D>{
	
	public ResponseEntity<Iterable<E>> getAll();
	
	public ResponseEntity<Object> save(D entity);
		
	public ResponseEntity<Object> update(D entity, Long id);
	
	public ResponseEntity<Object> delete(Long id);
	
	public Object getById(Long id);
}