package ru.spring.util;

import ru.spring.entity.Referrer;

public class ReferrerUtil {
	public static Referrer createReferrer() {
		Referrer referrer = new Referrer();
		referrer.setId(1);
		referrer.setNumOfFollowers(0);
		referrer.setRefName("Ivan");

		return referrer;
	}
}
