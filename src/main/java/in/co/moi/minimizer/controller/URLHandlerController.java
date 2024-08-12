package in.co.moi.minimizer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.co.moi.minimizer.data.dto.URLActivateStateDTO;
import in.co.moi.minimizer.data.dto.URLCreateDTO;
import in.co.moi.minimizer.data.dto.URLDeleteDTO;
import in.co.moi.minimizer.data.dto.URLDetailDTO;
import in.co.moi.minimizer.data.dto.URLSearchDTO;
import in.co.moi.minimizer.data.dto.URLUpdateDTO;
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

		String userId = headers.get("user_id");
		String response = urlHandlerService.createURLHandler(userId, urlCreateDTO);
		return response;
	}

	@PostMapping("/delete")
	public String deleteShortHand(@RequestHeader Map<String, String> headers, @RequestBody URLDeleteDTO urlDeleteDTO) {
		String userId = headers.get("user_id");
		String response = urlHandlerService.deleteURLHandler(userId, urlDeleteDTO);
		return response;
	}

	@PostMapping("/update")
	public String updateShortHand(@RequestHeader Map<String, String> headers, @RequestBody URLUpdateDTO urlUpdateDTO) {
		String userId = headers.get("user_id");
		String response = urlHandlerService.updateURLHandler(userId, urlUpdateDTO);
		return response;
	}

	@PostMapping("/activate")
	public String activateShortHand(@RequestHeader Map<String, String> headers,
			@RequestBody URLActivateStateDTO urlActivateStateDTO) {
		String userId = headers.get("user_id");
		String response = urlHandlerService.activateURLHandler(userId, urlActivateStateDTO);
		return response;

	}

	@GetMapping("/search")
	public URLDetailDTO searchURL(@RequestHeader Map<String, String> headers,
			@RequestBody URLSearchDTO urlSearchDTO) {
		String userId = headers.get("user_id");
		URLDetailDTO response = urlHandlerService.searchURLHandler(userId, urlSearchDTO);
		return response;

	}

	@GetMapping("/searchbyUser")
	public List<URLDetailDTO> searchByUserURL(@RequestHeader Map<String, String> headers) {
		String userId = headers.get("user_id");
		List<URLDetailDTO> response = urlHandlerService.searchByUserURLHandler(userId);
		return response;

	}
}
