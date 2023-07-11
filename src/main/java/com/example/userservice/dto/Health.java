package com.example.userservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

public class Health {

	@Getter
	public static class Response {

		private boolean alive;
		private int port;

		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime now;

		public Response(boolean alive, int port) {
			this.alive = alive;
			this.port = port;
			this.now = LocalDateTime.now();
		}
	}
}
