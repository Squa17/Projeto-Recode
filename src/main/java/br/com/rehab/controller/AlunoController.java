package br.com.rehab.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rehab.model.Aluno;
import br.com.rehab.model.Curso;
import br.com.rehab.services.AlunoService;
import br.com.rehab.services.CursoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public String listarAlunos(Model model) { 
		List<Aluno> aluno = alunoService.getAllAluno();
		model.addAttribute("aluno", aluno);
		return "pages/alunos/ListarAlunos";
	}
	
	@GetMapping("/novo")
	public String showForm(Model model) { 
		Aluno aluno = new Aluno();
		List<Curso> cursos = cursoService.getAllCursos();
		model.addAttribute("aluno", aluno);
		model.addAttribute("cursos", cursos);
		return "pages/alunos/alunoForm";
	}
	
	@PostMapping("/save")
	public String saveAluno(@ModelAttribute("aluno") Aluno aluno, @RequestParam Set<Long> cursos) { 
		aluno.setCursos(cursos.stream()
				.map(cursoService::getCursoById)
				.collect(Collectors.toSet()));
		alunoService.saveAluno(aluno, cursos);
		return "redirect:/alunos";
	}
	
	@GetMapping("/editar/{id}")
	public String ShowUpdateForm(@PathVariable("id") Long id, Model model) { 
		Aluno aluno = alunoService.getAlunoById(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("cursos", cursoService.getAllCursos());
		return "pages/alunos/editarAluno";
	}
	
	@PostMapping("/editar/{id}")
	public String updateAluno(@PathVariable("id") Long id, @ModelAttribute("aluno") Aluno aluno) { 
		alunoService.updateAluno(id, aluno);
		return "redirect:/alunos";
	}
	
	@GetMapping("/deletar/{id}")
	public String deleteAluno(@PathVariable Long id) { 
		alunoService.deleteAluno(id);;
		return "redirect:/alunos";
	}
}
