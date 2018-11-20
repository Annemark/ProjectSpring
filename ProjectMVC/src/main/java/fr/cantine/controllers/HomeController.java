package fr.cantine.controllers;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
*DispatcherServlet将请求委派给控制器以执行特定于其的功能。
* @Controller注释指示特定类充当控制器的角色。
* @RequestMapping注释用于将URL映射到整个类或特定处理程序方法。
*/

@Controller//指示特定类充当控制器的角色。
public class HomeController {
	
	@RequestMapping(path={"/accueil", "/default"}, method=RequestMethod.GET)
	//@GetMapping ({"/accueil", "/default"})
	public String HomePage() { 
		return "home";
	}

	@PostMapping(value="/accueil", params= {"dateReouverture", "lieu"})	
	public String HomeEnPost(Model model,
			@RequestParam
			String lieu,
			
			@DateTimeFormat(iso=ISO.DATE) 
			@RequestParam
			Date dateReouverture ) {
		
			model.addAttribute("datedeReouverture", dateReouverture);
			model.addAttribute("lieu", lieu);
		return "homePost";
	}
	
	 
}
