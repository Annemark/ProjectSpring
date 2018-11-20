package fr.cantine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cantine.beans.Plat;
import fr.cantine.dao.DaoInterface;

@Controller
@RequestMapping("/carte")
public class CarteController {
	
	@Autowired
	//@Qualifer("fakeDao") "fakeDao" same as id, in the servelet-context; this @ can be useful when we get more DAO
	private DaoInterface<Plat> laCarte;// now the same as line under, later we can also use it , because , it's un interface
//	private FakePlatDao laCarte; now , the same as the line above, but later, when we use the DAO not fake but other DAO, this will not work.// DaoInterface<Plat> déjà dit le type
	@GetMapping("")
	public String afficherCarte(Model model) {
		
		
		//model.addAttribute("test", "coucou");
		model.addAttribute("listePlatsMiamia", laCarte.findAll());
				
		return "carte";// aller au "carte.jsp"
	}
}
