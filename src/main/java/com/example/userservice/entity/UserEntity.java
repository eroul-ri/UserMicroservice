package com.example.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 100, nullable = false, unique = true)
	private String email;

	@Column(length = 100, nullable = false, unique = true)
	private String userId;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 64, nullable = false)
	private String encryptPwd;

	@Builder
	public UserEntity(String email, String name, String userId, String encryptPwd) {
		this.email = email;
		this.name = name;
		this.userId = userId;
		this.encryptPwd = encryptPwd;
	}
}
