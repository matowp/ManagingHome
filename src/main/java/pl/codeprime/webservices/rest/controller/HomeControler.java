package pl.codeprime.webservices.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author MOwsians
 *
 */
@Controller
@RequestMapping("/")
public class HomeControler {
	
	@GetMapping("/")
    public RedirectView redirectWithUsingForwardPrefix(ModelMap model) {
        model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new RedirectView("index.html");
    }

}
