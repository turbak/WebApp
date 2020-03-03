package ru.spring.util;

import ru.spring.entity.Referrer;

public class ReferrerUtil {
	public static Referrer createReferrer() {
		Referrer referrer = new Referrer();
		referrer.setId(1);
		referrer.setNum_of_followers(0);
		referrer.setRef_name("Ivan");

		return referrer;
	}
}
