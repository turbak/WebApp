package ru.spring.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.spring.config.RootConfig;
import ru.spring.util.ReferrerUtil;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class ReferrerServiceTest {
	@Resource
	private EntityManagerFactory emf;
	protected EntityManager em;

	@Resource
	private ReferrerService referrerService;

	@Before
	public void setUp() {
		em = emf.createEntityManager();
	}

	@Test
	public void testSaveReferrer() {
		referrerService.addReferrer(ReferrerUtil.createReferrer());
	}
}
