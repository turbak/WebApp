package ru.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.entity.Referrer;
import ru.test.repository.ReferrerRepository;
import ru.test.service.ReferrerService;

import java.util.List;

@Service
public class ReferrerServiceImpl implements ReferrerService {
	@Autowired
	private ReferrerRepository referrerRepository;

	@Override
	public Referrer addReferrer(Referrer referrer) {
		Referrer save = referrerRepository.saveAndFlush(referrer);
		return save;
	}

	@Override
	public List<Referrer> getAll() {
		return referrerRepository.findAll();
	}
}
