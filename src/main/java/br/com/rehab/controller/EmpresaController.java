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


import br.com.rehab.model.Empresa;
import br.com.rehab.services.EmpresaService;



@Controller
@RequestMapping("/empresas")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	// Listar
		@GetMapping
		public String listEmpresas(Model model) {
			List<Empresa> empresas = empresaService.getAllEmpresas();
			model.addAttribute("empresas", empresas);
			return "pages/empresa/ListarEmpresas";
		}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("empresa", empresa);
		return "pages/empresa/empresaForm";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveEmpresa(@ModelAttribute("empresa") Empresa empresa) {
		empresaService.saveEmpresa(empresa);
		return "redirect:/empresas";
	}

	// Formulário de edição
	@GetMapping("/editar/{id}")
	public String showFormForUpdate(@PathVariable Long id, Model model) {
		Empresa empresa = empresaService.getEmpresaById(id);
		model.addAttribute("empresa", empresa);
		return "pages/empresa/editarEmpresa";
	}

	// Persistencia da edição
	@PostMapping("/editar/{id}")
	public String updateEmpresa(@PathVariable Long id, @ModelAttribute("empresa") 
	Empresa empresa) {
		empresaService.updateEmpresa(id, empresa);
		return "redirect:/empresas";
	}
	
	// Excluir categoria
	@GetMapping("/deletar/{id}")
	public String deleteEmpresa(@PathVariable Long id) { 
		empresaService.deleteEmpresa(id);
		return "redirect:/empresas";
	}

}