package fr.cantine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@RequestMapping("/{menu}/Day/{day}") //parametre de chemain,for example, the menu of Monday can be different of these of friday.
	public String GetMenuForday(
			@PathVariable ("menu") String monMenu,
			@PathVariable ("day")String jour,
			Model model) throws Exception {
		
		model.addAttribute("le_menu", monMenu);
		
		int [] toto = {1,32};
		int titi = toto[6];
		
		if (!jour.equalsIgnoreCase("lundi")) {
			model.addAttribute("le_jour", jour);
		}
		
		else {
			throw new Exception("Nous sommes fermés le lundi !");
		}
		return "menu";
		
	}
}
