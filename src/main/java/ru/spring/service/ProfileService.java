package ru.spring.service;

import ru.spring.entity.Profile;

import java.util.List;

public interface ProfileService {
	Profile addProfile(Profile profile);
	Profile getProfileByLogin(String login);
	Profile getProfileByLoginAndPassword(String login, String password);
	List<Profile> getAll();
	void deleteProfile(String login);
	Profile updateProfile(Profile profile, String login);
}
