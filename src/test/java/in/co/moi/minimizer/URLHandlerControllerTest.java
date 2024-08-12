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

import in.co.moi.minimizer.controller.URLHandlerController;

@SpringBootTest(classes = URLHandlerController.class)
@ContextConfiguration
@AutoConfigureMockMvc
public class URLHandlerControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void greetTest() throws Exception {

        mockMvc.perform(get("/greet?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void searchURLTest() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void searchByUserURL() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void createShortHandTest() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void deleteShortHandTest() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void updateShortHandTest() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
	@Test
    public void activateShortHandTest() throws Exception {

        mockMvc.perform(get("/create?message=abc"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello ! abc"));
    }
	
}
