package ru.test.service;

import ru.test.entity.Profile;

import java.util.List;

public interface ProfileService {
	Profile addProfile(Profile profile);
	Profile getProfileByLogin(String login);
	Profile getProfileByLoginAndPassword(String login, String password);
	List<Profile> getAll();
}
