package ru.test.service.impl;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.entity.Profile;
import ru.test.repository.ProfileRepository;
import ru.test.service.ProfileService;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	@Transactional
	public Profile addProfile(Profile profile) {
		return profileRepository.saveAndFlush(profile);
	}

	@Override
	@Transactional(readOnly = true)
	public Profile getProfileByLogin(String login) {
		Profile profile = profileRepository.getProfileByLogin(login);
		Hibernate.initialize(profile.getReferrer());
		return profile;
	}

	@Override
	@Transactional(readOnly = true)
	public Profile getProfileByLoginAndPassword(String login, String password) {
		return profileRepository.getProfileByLoginAndPassword(login, password);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profile> getAll() {
		return profileRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteProfile(String login) {
		profileRepository.deleteByLogin(login);
	}
}
