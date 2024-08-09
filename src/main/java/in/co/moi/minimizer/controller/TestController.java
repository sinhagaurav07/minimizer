package in.co.moi.minimizer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@GetMapping("/greet")
	public String greet(@RequestParam String message) {
		return "Hello ! " + message;
		
	}
}
