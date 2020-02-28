package ru.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.entity.Referrer;
import ru.test.repository.ReferrerRepository;
import ru.test.service.ReferrerService;

import java.util.List;

@Service
public class ReferrerServiceImpl implements ReferrerService {
	@Autowired
	private ReferrerRepository referrerRepository;

	@Override
	@Transactional()
	public Referrer addReferrer(Referrer referrer) {
		Referrer save = referrerRepository.save(referrer);
		return save;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Referrer> getAll() {
		return referrerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Referrer getReferrer(Integer id) {
		return referrerRepository.getOne(id);
	}
}
