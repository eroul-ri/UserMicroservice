package com.example.userservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.userservice.common.constant.ERR_CODE;
import com.example.userservice.dto.User;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.exception.UserServiceException;
import com.example.userservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public void registerUser(User.UserInfo userInfo) throws UserServiceException {
		userInfo.setUserId(UUID.randomUUID().toString());

		UserEntity userEntity = userInfo.toEntity();

		userRepository.save(userEntity);

		if(userEntity.getId() == null) {
			throw new UserServiceException(ERR_CODE.SIGN_UP_FAIL);
		}
	}
}
