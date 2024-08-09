package in.co.moi.minimizer;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import in.co.moi.minimizer.controller.URLHandlerController;

@Import(TestcontainersConfiguration.class)
@SpringBootTest (classes = URLHandlerController.class)
@ContextConfiguration
class MinimizerApplicationTests {
	
	@Autowired
	private URLHandlerController uRLHandlerController;

	@Test
	void contextLoads() {
		assertNotNull(uRLHandlerController);
	}

}
