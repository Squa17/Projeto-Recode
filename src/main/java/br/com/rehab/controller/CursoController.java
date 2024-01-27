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
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;

	
	// Listar
		@GetMapping
		public String listCursos(Model model) {
			List<Curso> cursos = cursoService.getAllCursos();
			model.addAttribute("cursos", cursos);
			return "pages/curso/ListarCursos";
		}
		
		
		
		
		// Formulário de criação
		@GetMapping("/novo")
		public String showFormForAdd(Model model) {
			Curso curso = new Curso();
			model.addAttribute("curso", curso);
			return "pages/curso/cursoForm";
		}
		
		// Persistencia da criação
		@PostMapping("/save")
		public String saveCurso(@ModelAttribute("curso") Curso curso) {
			cursoService.saveCurso(curso);
			return "redirect:/cursos";
		}
		
		// Formulário de edição
		@GetMapping("/editar/{id}")
		public String showFormForUpdate(@PathVariable Long id, Model model) {
			Curso curso = cursoService.getCursoById(id);
			model.addAttribute("curso", curso);
			return "pages/curso/editarCurso";
		}
		
		
		
		
		// Persistencia da edição
		@PostMapping("/editar/{id}")
		public String updateCurso(@PathVariable Long id, @ModelAttribute("curso") 
		Curso curso) {
			cursoService.updateCurso(id, curso);
			return "redirect:/cursos";
		}
		
		// Excluir categoria
		@GetMapping("/deletar/{id}")
		public String deleteCurso(@PathVariable Long id) { 
			cursoService.deleteCurso(id);
			return "redirect:/cursos";
		}

}
