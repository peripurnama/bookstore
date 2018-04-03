package peripurnama.controller;

import java.security.Principal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

//	@GetMapping("/success")
//	public String success(Model model, Principal principal) {
//		if (principal != null) {
//			model.addAttribute("message", "Hello: " + principal.getName());
//			return "/success";
//		}
//		return "redirect:/";
//	}
//
//	@GetMapping("/login")
//	public String login(Model model) {
//		return "login";
//	}

	// @RequestMapping(path = "/error")
	// public Map<String, Object> handle(HttpServletRequest request) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("status", request.getAttribute("javax.servlet.error.status_code"));
	// map.put("reason", request.getAttribute("javax.servlet.error.message"));
	// return map;
	// }

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		ModelAndView errorPage = new ModelAndView("error");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400: {
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 404: {
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 500: {
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}
