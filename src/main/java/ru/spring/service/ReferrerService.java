package ru.spring.service;

import ru.spring.entity.Referrer;

import java.util.List;

public interface ReferrerService {
	Referrer addReferrer(Referrer referrer);
	List<Referrer> getAll();
	Referrer getReferrer(Integer id);
}
