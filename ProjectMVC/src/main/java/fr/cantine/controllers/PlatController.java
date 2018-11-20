package fr.cantine.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.cantine.beans.Plat;
import fr.cantine.dao.DaoInterface;

@Controller
@RequestMapping("/plat") // donner le chemain pour index, pour passer par controller here and return
							// "newPlat" --> va cette page
public class PlatController {

	@Autowired
	private DaoInterface<Plat> dao;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/new")
	public String afficherAjouterPlat() {
		return "newPlat";
	}

//	@PostMapping("/new")
//	public String ajouterPlat(Model model,
//			@RequestParam String nom,
//			@RequestParam float prix,
//			@RequestParam TypePlat typePlat
//			) {
//		
//		System.out.println(nom +"," + prix + "," + typePlat);
//		
//		Plat plat = new Plat();
//		plat.setNom(nom);
//		plat.setPrix(prix);
//		plat.setTypePlat(typePlat);
//		
//		plat = dao.createOrUpdate(plat);
//		
//		model.addAttribute("listePlatsMiamia", dao.findAll());
//		model.addAttribute("msg", "Nouveau plat ajouté : " + plat);
//		return "carte";
//	}
//	

	@PostMapping("/new")
	public String ajouterPlat(Model model, Plat plat) {

		dao.createOrUpdate(plat);
		return afficheCarte(model, "Nouveau plat ajouté : " + plat);
	}

	@PostMapping("/delete")
	public String supprimerPlat(Model model, @RequestParam Long id) {
		Plat plat = dao.findById(id);
		dao.delete(id);
		return afficheCarte(model, "Plat supprimé !" + plat.getNom());
	}

	@PostMapping("/upload")
		public String ajoutImage(Model model, Locale locale,
				HttpServletRequest request,
				@RequestParam("image_plat") MultipartFile file,
				@RequestParam("id") Long id) { // "image_plat" correspond le nom dans carte.jsp	
		
			String path = request.getServletContext().getRealPath("uploaded");
			System.out.println(path);
			File directory = new File(path);
			if(!directory.exists()) {
				directory.mkdirs();
			}
			
		try {		
			File fichierDestination = new File(directory, new Date().getTime() + "_" + file.getOriginalFilename());
			FileOutputStream stream = new FileOutputStream(fichierDestination);
			stream.write(file.getBytes());
			stream.close();
			
			Plat plat = dao.findById(id);
			plat.setImage(fichierDestination.getName());
			dao.createOrUpdate(plat);
			
			//return afficheCarte (model, "Ficher uploadé : " + fichierDestination.getName());
			String [] parametres = new String[] {fichierDestination.getName(), new Date().toString()};//deux chaines de caracters
			return afficheCarte(model, messageSource.getMessage("T_UPLOAD_SUCESS", parametres, locale));
			
		}catch(Exception ex) {
				ex.printStackTrace();
				return afficheCarte(model, messageSource.getMessage("T_UPLOAD_ERROR", null, locale));
			}
			 
		 }

	private String afficheCarte(Model model, String message) {
		model.addAttribute("listePlatsMiamia", dao.findAll());
		model.addAttribute("msg", message);
		return "carte";
	}

	
}
