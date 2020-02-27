package ru.test.util;

import ru.test.entity.Profile;

public class ProfileUtil {
	public static Profile createProfile() {
		Profile profile = new Profile();

		profile.setAdmin(false);
		profile.setId(1);
		profile.setLogin("user");
		profile.setName("Ivan");
		profile.setSurname("Shcherbina");
		profile.setPassword("qwerty");
		profile.setReferrer(null);

		return profile;
	}
}
