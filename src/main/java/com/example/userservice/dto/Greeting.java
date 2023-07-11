package com.example.userservice.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Component
@NoArgsConstructor
public class Greeting {
	@Value("${greeting.message}")
	private String message;
}
