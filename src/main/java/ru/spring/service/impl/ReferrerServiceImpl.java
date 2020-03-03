package ru.spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.entity.Referrer;
import ru.spring.repository.ReferrerRepository;
import ru.spring.service.ReferrerService;

import java.util.List;

@Service
public class ReferrerServiceImpl implements ReferrerService {
	private final ReferrerRepository referrerRepository;

	public ReferrerServiceImpl(ReferrerRepository referrerRepository) {
		this.referrerRepository = referrerRepository;
	}

	@Override
	@Transactional()
	public Referrer addReferrer(Referrer referrer) {
		return referrerRepository.save(referrer);
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
