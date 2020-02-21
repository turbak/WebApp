package ru.test.service;

import ru.test.models.Login;
import ru.test.models.User;

public interface UserAuth {

	boolean isValid(Login login);

	User getUser(String name);

	User registerUser(User user);
}
