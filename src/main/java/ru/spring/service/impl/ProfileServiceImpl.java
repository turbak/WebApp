package ru.spring.service.impl;

import org.hibernate.Hibernate;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.entity.Profile;
import ru.spring.repository.ProfileRepository;
import ru.spring.service.ProfileService;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
	private final ProfileRepository profileRepository;

	public ProfileServiceImpl(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@Override
	@Transactional
	public Profile addProfile(Profile profile) {
		return profileRepository.saveAndFlush(profile);
	}

	@Override
	@Transactional(readOnly = true)
	public Profile getProfileByLogin(String login) {
		Profile profile = profileRepository.getProfileByLogin(login.trim());
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
		return profileRepository.findAll(Sort.by(Sort.Direction.ASC, "Id"));
	}

	@Override
	@Transactional
	public void deleteProfile(String login) {
		profileRepository.deleteByLogin(login);
	}

	@Override
	public Profile updateProfile(Profile profile, String login) {
		Profile updated = profileRepository.getProfileByLogin(login);
		updated.setName(profile.getName());
		updated.setSurname(profile.getSurname());
		updated.setReferrer(profile.getReferrer());
		return profileRepository.save(updated);
	}
}
