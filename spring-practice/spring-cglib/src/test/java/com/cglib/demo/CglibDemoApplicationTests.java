package com.cglib.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CglibDemoApplicationTests {

	@Autowired
	ApplicationContext 	applicationContext;

	@Test
	void contextLoads() {
		PostRepository postRepository = applicationContext.getBean("postRepository", PostRepository.class);
		DefaultPostService firstPostService = applicationContext.getBean("firstPostService", DefaultPostService.class);
		DefaultPostService secondPostService = applicationContext.getBean("secondPostService", DefaultPostService.class);

		System.out.println(firstPostService.getPostRepository());
		System.out.println(secondPostService.getPostRepository());
		System.out.println(postRepository);
		System.out.println("============================================================");
		System.out.println(firstPostService.getLogService());
		System.out.println(secondPostService.getLogService());
	}

}
