package com.marcebits.demo.utils;

import lombok.Data;

@Data
public class ResponseDto<T> {

	ResponseDto() { }
	
	T response;
	
	boolean success;
	
	String error;	
	
	public static <T> ResponseDto<T> success(T content) {
		ResponseDto<T> responseDto = new ResponseDto<>();
		responseDto.setResponse(content);
		responseDto.setSuccess(true);
		responseDto.setError(null);
		return responseDto;
	}
	
	public static <T> ResponseDto<T> fail(String error) {
		ResponseDto<T> responseDto = new ResponseDto<>();
		responseDto.setResponse(null);
		responseDto.setSuccess(false);
		responseDto.setError(error);
		return responseDto;
	}
}
