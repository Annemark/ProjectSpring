package fr.cantine.utils;

import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalErrorHandler {
	
	@ExceptionHandler
	public String handleExceptionDefault (Model model, Exception ex, Locale locale) {
		
		model.addAttribute("erreur", ex.getMessage());
		return "error";
	}
	
	//@ExceptionHandler({NumberFormatException.class, RunTimeException.class})
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public String handleException404 (Model model, Exception ex, Locale locale) {
//		
//		model.addAttribute("erreur", ex.getMessage());
//		return "error";
//	}
//	

}
