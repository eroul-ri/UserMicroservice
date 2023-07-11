package com.example.userservice.common.dto;

import org.apache.commons.lang.StringUtils;

import com.example.userservice.common.constant.ERR_CODE;

public class ErrorResponse {
	private String code;
	private String message;

	public ErrorResponse(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorResponse(ERR_CODE errCode) {
		this.code = errCode.getErrCode();
		this.message = errCode.getErrMessage();
	}

	public static ErrorResponse commonErrorResponse(ERR_CODE errCode) {
		return new ErrorResponse(errCode);
	}

	public static ErrorResponse internalServerErrorResponse(String message) {
		if(StringUtils.isEmpty(message)) {
			return new ErrorResponse(ERR_CODE.SERVER_ERR);
		}

		return new ErrorResponse(ERR_CODE.SERVER_ERR.getErrCode(), message);
	}
}
