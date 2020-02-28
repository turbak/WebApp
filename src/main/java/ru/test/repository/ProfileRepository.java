package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.test.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	Profile getProfileByLogin(String login);

	Profile getProfileByLoginAndPassword(String login, String password);

	void deleteByLogin(String login);

	@Modifying(flushAutomatically = true)
	@Query("UPDATE Profile p SET p.name = ?1, p.surname = ?2 WHERE p.login = ?3")
	void updateProfileByLogin(String name, String surname, String login);
}
