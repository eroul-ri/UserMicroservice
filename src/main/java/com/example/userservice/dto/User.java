package com.example.userservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.userservice.entity.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class User {

	@Getter
	public static class Request {
		@NotBlank(message = "name is required")
		@Size(min = 2)
		private String name;

		@NotBlank(message = "email is required")
		@Size(min = 2)
		@Email
		private String email;

		@NotBlank(message = "password is required")
		@Size(min = 4)
		private String pwd;

		public UserInfo toUserInfo() {
			return UserInfo.builder()
						   .name(name)
						   .email(email)
						   .pwd(pwd)
						   .build();
		}
	}

	@Getter
	public static class UserInfo {
		private String name;
		private String email;
		private String encryptPwd;

		@Setter
		private String userId;

		@Builder
		public UserInfo(String name, String email, String pwd) {
			this.name = name;
			this.email = email;
			this.encryptPwd = pwd; // fixme eroul-ri 패스워드 암호화 SKIP
		}

		public UserEntity toEntity() {
			return UserEntity.builder()
							 .userId(userId)
							 .encryptPwd(encryptPwd)
							 .name(name)
							 .email(email)
							 .build();
		}
	}

	@Getter
	public static class Response {
		private String userId;
		private String name;
		private String email;

		public Response(User.UserInfo userInfo) {
			this.userId = userInfo.getUserId();
			this.name = userInfo.getName();
			this.email = userInfo.getEmail();
		}
	}
}
