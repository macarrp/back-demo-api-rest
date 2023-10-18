package com.marcebits.demo.provider;

import java.util.List;

import com.marcebits.demo.utils.ResponseDto;

public interface BaseProvider<T> {

	ResponseDto<List<T>> getAll();
	
	ResponseDto<T> getById(Long id);
	
	ResponseDto<Long> add(T newObject);
	
	ResponseDto<String> update(Long id, T newObject);
	
	ResponseDto<String> delete(Long id);
}
