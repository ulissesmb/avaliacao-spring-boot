package br.com.tokiomarine.seguradora.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;

@Controller
public class InitController {
	
	@Autowired
	EstudandeService estudandeService;

	@GetMapping("/")
	public ModelAndView index(Model model) throws Exception {
		return new ModelAndView("/estudante/listar").addObject("estudantes",estudandeService.getAll());
	}

}
