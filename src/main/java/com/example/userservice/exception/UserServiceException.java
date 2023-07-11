package com.example.userservice.exception;

import com.example.userservice.common.constant.ERR_CODE;

import lombok.Getter;

public class UserServiceException extends RuntimeException {
	@Getter
	private ERR_CODE errCode;

	public UserServiceException(String message) {
		super(message);
	}

	public UserServiceException(ERR_CODE errCode) {
		super(errCode.getErrMessage());
		this.errCode = errCode;
	}
}
