package ru.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.dao.UserDao;
import ru.test.models.Login;
import ru.test.models.User;

@Service
public class UserService implements UserAuth {

	@Autowired
	UserDao userDao;

	public boolean isValid(Login login) {
		return userDao.validateUser(login) != null;
	}

	@Override
	public User getUser(String name) {
		return userDao.getUser(name);
	}

	@Override
	public User registerUser(User user) {
		return userDao.register(user);
	}
}
