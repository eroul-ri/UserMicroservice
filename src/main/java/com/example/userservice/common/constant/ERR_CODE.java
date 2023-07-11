package com.example.userservice.common.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ERR_CODE {
	SERVER_ERR(HttpStatus.INTERNAL_SERVER_ERROR, "-500", "Internal Server Error"), SIGN_UP_FAIL(HttpStatus.BAD_REQUEST,
		"-4000",
		"SIGN_UP_FAIL");

	private HttpStatus httpStatus;
	private String errCode;
	private String errMessage;
}
