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

		profile.setLogin(String.valueOf(random.nextInt(1000000)));
		profile.setPassword(String.valueOf(random.nextInt(1500000)));
		profile.setName(String.valueOf(random.nextFloat()));
		profile.setSurname(String.valueOf(random.nextFloat()));
		profile.setReferrer(null);
		return profile;
	}
}
