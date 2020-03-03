package ru.spring.service;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.spring.config.RootConfig;
import ru.spring.util.ProfileUtil;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.concurrent.atomic.AtomicLong;

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

	@Test
	public void multiThread() throws Exception {
		AtomicLong count1 = new AtomicLong(profileService.getAll().size());
		for (int i = 0; i < 50; i++) {
			new Thread(() -> {
				try {
					profileService.addProfile(ProfileUtil.createRandomProfile());
					profileService.getAll();
				} catch (ConstraintViolationException e) {
					count1.decrementAndGet();
				}
			}).start();
		}
		Thread.sleep(1000);
		Assert.assertEquals(count1.addAndGet( 50), profileService.getAll().size());
	}
}
