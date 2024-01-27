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

import br.com.rehab.model.Curso;
import br.com.rehab.services.CursoService;



@Controller
@RequestMapping("/admin") 
 
public class AdminController {
 

	@Autowired
	private CursoService cursoService;

	 
	//* <----cursos--------------- *\
	@GetMapping
	public String listCursos(Model model) {
		List<Curso> cursos = cursoService.getAllCursos();
		model.addAttribute("cursos", cursos);
		return "pages/admin/home";
	}
	
	 
	
	@GetMapping("/curso")
	public String showFormForAdd(Model model) {
		Curso curso = new Curso();
		model.addAttribute("curso", curso);
		return "pages/admin/cursoForm";
	}
	 
	// Persistencia da criação
	@PostMapping("/curso/save")
	public String saveCurso(@ModelAttribute("curso") Curso curso) {
		cursoService.saveCurso(curso);
		return "redirect:/pages/admin";
		///return "admin";
		
	}
	
	// Formulário de edição
			@GetMapping("/curso/editar/{id}")
			public String showFormForUpdate(@PathVariable Long id, Model model) {
				Curso curso = cursoService.getCursoById(id);
				model.addAttribute("curso", curso);
				return "pages/admin/editarCurso";
			}
			
			
			
			// Persistencia da edição
			@PostMapping("curso/editar/{id}")
			public String updateCurso(@PathVariable Long id, @ModelAttribute("curso") 
			Curso curso) {
				cursoService.updateCurso(id, curso);
				return "redirect:/pages/admin";
			}
			

			// Excluir categoria
			@GetMapping("curso/deletar/{id}")
			public String deleteCurso(@PathVariable Long id) { 
				cursoService.deleteCurso(id);
				return "redirect:/pages/admin";
			}
	
	 
}







