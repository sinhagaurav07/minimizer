package in.co.moi.minimizer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.co.moi.minimizer.data.dto.URLCreateDTO;
import in.co.moi.minimizer.service.URLHandlerService;

@RestController
public class URLHandlerController {

	@Autowired
	URLHandlerService urlHandlerService;

	@GetMapping("/greet")
	public String greet(@RequestParam String message) {
		return "Hello ! " + message;

	}

	@PostMapping("/create")
	public String createShortHand(@RequestHeader Map<String, String> headers, @RequestBody URLCreateDTO urlCreateDTO) {

		String userId = headers.get("USER_ID");
		urlHandlerService.createURLHandler(userId, urlCreateDTO);
		return null;
	}

	@GetMapping("/delete")
	public String deleteShortHand(@RequestParam String message) {
		return "Hello ! " + message;

	}

	@GetMapping("/update")
	public String updateShortHand(@RequestParam String message) {
		return "Hello ! " + message;

	}

	@GetMapping("/activate")
	public String activateShortHand(@RequestParam String message) {
		return "Hello ! " + message;

	}
}
