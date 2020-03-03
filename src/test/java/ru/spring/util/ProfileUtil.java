package ru.spring.util;

import ru.spring.entity.Profile;

import java.util.Random;

public class ProfileUtil {

	public static Profile createProfile() {
		Profile profile = new Profile();

		profile.setAdmin(true);
		profile.setLogin("user");
		profile.setName("Ivan");
		profile.setSurname("Shcherbina");
		profile.setPassword("qwerty");
		profile.setReferrer(null);

		return profile;
	}

	public static Profile createRandomProfile() {
		Profile profile = new Profile();
		Random random = new Random();

		StringBuilder name = new StringBuilder();
		StringBuilder surname = new StringBuilder();
		for (int i = 0; i < random.nextInt(20) + 5; i++) {
			name.append((char) (random.nextInt(27) + 65));
			surname.append((char) (random.nextInt(27) + 65));
		}
		profile.setLogin(String.valueOf(random.nextInt(1000000)));
		profile.setPassword(String.valueOf(random.nextInt(1500000)));
		profile.setName(name.toString());
		profile.setSurname(surname.toString());
		profile.setReferrer(null);
		return profile;
	}
}
