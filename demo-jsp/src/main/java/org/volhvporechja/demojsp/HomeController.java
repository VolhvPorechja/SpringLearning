package org.volhvporechja.demojsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.volhvporechja.demojsp.dao.Offer;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@Controller
public class HomeController {

	@Autowired
	OffersRepository offersRepository;

	@RequestMapping("/")
	public String home(HttpSession model) {
		return "home";
	}

	@RequestMapping("/some")
	public String some(HttpSession model) {
		model.setAttribute("message", "Fuck you some!!");

		return "home";
	}

	@RequestMapping("/other")
	public String other(HttpSession model) {
		model.setAttribute("message", "Fuck you other!!");

		return "home";
	}

	@RequestMapping("/mv")
	public ModelAndView mv() {
		ModelAndView home = new ModelAndView("home");
		home.getModel().put("message", "Fucking model and view");

		return home;
	}

	@RequestMapping("/offers")
	public String getOffers(Map<String, Object> model) {
		model.put("offers", offersRepository.getOffers().toArray());
		return "offer";
	}
}