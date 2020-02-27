package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	Profile getProfileByLogin(String login);
	Profile getProfileByLoginAndPassword(String login, String password);
}
