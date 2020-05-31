package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokiomarine.seguradora.avaliacao.domain.entity.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.domain.enums.CursoEnum;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {
	
	private static final String MSG_NOT_ID = "ID informado não existe"; 
	private static final String PATH = "estudante";
	private static final String CADASTRAR = PATH + "/cadastrar";
	private static final String ATUALIZAR = PATH + "/atualizar";
	private static final String LISTAR = PATH + "/listar";
	private static final String LISTAR_REDIRECT = "redirect:/";
	

	@Autowired
	EstudandeService estudanteService;

	@GetMapping("criar")
	public ModelAndView iniciarCastrado(Estudante estudante,  Model model) throws Exception {
		model.addAttribute("cursos", CursoEnum.values());
		return new ModelAndView(CADASTRAR);
	}

	@GetMapping("listar")
	public String listarEstudantes(Model model) throws Exception {
		model.addAttribute("estudantes", estudanteService.getAll());
		return "index";
	}

	@PostMapping("add")
	public ModelAndView adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("cursos", CursoEnum.values());
			return new ModelAndView(CADASTRAR);
		}

		estudanteService.save(estudante);
		model.addAttribute("success", "Registro cadastrado com sucesso");
		return new ModelAndView(LISTAR_REDIRECT).addObject("estudantes", estudanteService.getAll());
	}

	@GetMapping("editar/{id}")
	public ModelAndView exibirEdicaoEstudante(@PathVariable("id") long id, Model model) throws Exception {
		Estudante estudante = estudanteService.getById(id);
		model.addAttribute("estudante", estudante)
		.addAttribute("cursos", CursoEnum.values());
		return new ModelAndView(ATUALIZAR);
	}

	@PostMapping("atualizar/{id}")
	public ModelAndView atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) throws Exception {
		if (result.hasErrors()) {
			return new ModelAndView(ATUALIZAR);
		}
		
		Estudante resultEstudante = estudanteService.getById(id);
		if(resultEstudante != null) {
			estudanteService.save(estudante);
			model.addAttribute("estudantes", estudanteService.getAll());
			return new ModelAndView(LISTAR_REDIRECT);
		}
		
		model.addAttribute("warning", MSG_NOT_ID);
		return new ModelAndView(LISTAR_REDIRECT);
		
	}

	@GetMapping("apagar/{id}")
	public ModelAndView apagarEstudante(@PathVariable("id") long id, Model model) throws Exception {
		
		Estudante estudante = estudanteService.getById(id);
		if(estudante != null) {
			estudanteService.delete(estudante);
			model.addAttribute("estudantes", estudanteService.getAll());
			return new ModelAndView(LISTAR_REDIRECT);
		}
		
		model.addAttribute("warning", MSG_NOT_ID);
		return new ModelAndView(LISTAR_REDIRECT);
		
	}
}
