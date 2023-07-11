package com.example.userservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userservice.common.constant.ERR_CODE;
import com.example.userservice.common.dto.ErrorResponse;
import com.example.userservice.exception.UserServiceException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<ErrorResponse> userServiceCustomError(UserServiceException e) {
		ERR_CODE errCode = e.getErrCode();

		return ResponseEntity.status(errCode.getHttpStatus())
							 .body(ErrorResponse.commonErrorResponse(errCode));
	}

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorResponse> internalServerError(Exception e) {
		log.error("internalServerError : {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							 .body(ErrorResponse.internalServerErrorResponse(e.getMessage()));
	}
}
