package ru.test.service;

import org.springframework.context.annotation.Bean;

public class UserAuth {

	public boolean isValid(String login, String password) {
		return (login.equals("user") && password.equals("qwerty"));
	}
}
