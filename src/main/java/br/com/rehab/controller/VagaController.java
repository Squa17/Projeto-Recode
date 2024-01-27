package br.com.rehab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rehab.entities.Vaga;
import br.com.rehab.services.VagaService;

@Controller
@RequestMapping("/vagas")
public class VagaController {
	
	@Autowired
	private VagaService vagaService;
	
	// Listar
			@GetMapping
			public String listVagas(Model model) {
				List<Vaga> vagas = vagaService.getAllVagas();
				model.addAttribute("vagas", vagas);
				return "pages/vagas/ListarVagas";
			}
			
			// Formulário de criação
			@GetMapping("/novo")
			public String showFormForAdd(Model model) {
				Vaga vaga = new Vaga();
				model.addAttribute("vaga", vaga);
				return "pages/vagas/vagaForm";
			}
			
			// Persistencia da criação
			@PostMapping("/save")
			public String saveVaga(@ModelAttribute("vaga") Vaga vaga) {
				vagaService.saveVaga(vaga);
				return "redirect:/vagas";
			}
			
			// Formulário de edição
			@GetMapping("/editar/{id}")
			public String showFormForUpdate(@PathVariable Long id, Model model) {
				Vaga vaga = vagaService.getVagaById(id);
				model.addAttribute("vaga", vaga);
				return "pages/vagas/editarVaga";
			}
			
			// Persistencia da edição
			@PostMapping("/editar/{id}")
			public String updateVaga(@PathVariable Long id, @ModelAttribute("vaga") 
			Vaga vaga) {
				vagaService.updateVaga(id, vaga);
				return "redirect:/vagas";
			}
			
			// Excluir categoria
			@GetMapping("/deletar/{id}")
			public String deleteVaga(@PathVariable Long id) { 
				vagaService.deleteVaga(id);
				return "redirect:/vagas";
			}

}
