package br.com.rehab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.springmvc.entities.Produto;
//import com.springmvc.service.ProdutoService;

@Controller
public class RoutesController {
	
	 
	@GetMapping ("/")
	public String mostraIndex(Model model) {
		model.addAttribute("index", "index");
		return "pages/Index";
	}
	
	
	@GetMapping("/login")
	public String login() { 
		return "pages/login";
	}
	@GetMapping("/Qiqi")
	public String Qiqi() { 
		return "pages/qiqi";
	}
	

	
	
	
}
