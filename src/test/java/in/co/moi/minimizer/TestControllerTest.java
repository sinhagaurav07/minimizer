package in.co.moi.minimizer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import in.co.moi.minimizer.controller.TestController;

@SpringBootTest(classes = TestController.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class TestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void shouldReturnExpectedMessage() throws Exception {

        mockMvc.perform(get("/greet?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
}
