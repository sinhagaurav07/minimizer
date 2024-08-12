package in.co.moi.minimizer;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

public class BaseTest {
	
    @BeforeEach 
    public void setup() {
    	MockitoAnnotations.initMocks(this);
    }
	  

}
