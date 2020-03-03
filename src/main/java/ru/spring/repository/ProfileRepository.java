package ru.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.spring.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	Profile getProfileByLogin(String login);

	Profile getProfileByLoginAndPassword(String login, String password);

	void deleteByLogin(String login);

	Profile getFirstByLogin(String login);
}
