package ru.test.service;

import ru.test.entity.Referrer;

import java.util.List;

public interface ReferrerService {
	Referrer addReferrer(Referrer referrer);
	List<Referrer> getAll();
	Referrer getReferrer(Integer id);
}
