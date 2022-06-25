package com.ufc.web.chatly.common;

import java.util.UUID;

import org.springframework.http.ResponseEntity;

public interface BaseController <E, D>{
	
	public Iterable<E> getAll();
	
	public ResponseEntity<Object> save(D entity);
		
	public ResponseEntity<Object> update(D entity, UUID id);
	
	public ResponseEntity<Object> delete(UUID id);
	
	public Object getById(UUID id);
}