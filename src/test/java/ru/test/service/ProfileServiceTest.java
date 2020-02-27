package ru.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.test.config.RootConfig;
import ru.test.service.ProfileService;
import ru.test.util.ProfileUtil;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@WebAppConfiguration
public class ProfileServiceTest {
	@Resource
	private EntityManagerFactory emf;
	protected EntityManager em;

	@Resource
	private ProfileService profileService;

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@Test
	public void testSaveProfile() throws Exception {
		profileService.addProfile(ProfileUtil.createProfile());
	}
}
