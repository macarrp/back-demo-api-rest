package com.marcebits.demo.provider;

import java.util.List;

public interface BaseProvider<T> {

	List<T> getAll();
	
	T getById(Long id);
	
	Long add(T newObject);
	
	String update(T newObject);
	
	String delete(Long id);
}
