package ru.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.test.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	Profile getProfileByLogin(String login);

	Profile getProfileByLoginAndPassword(String login, String password);

	void deleteByLogin(String login);;
}
