package br.com.impacta.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.enums.Categoria;
import br.com.impacta.models.Despesa;
import br.com.impacta.services.DespesasService;

@Controller
@RequestMapping("/despesas")
public class DespesasController {

	private static final String VIEW_CADASTRO = "despesas/cadastro";
	private static final String VIEW_LISTAGEM = "despesas/listagem";
	
	@Autowired
	private DespesasService despesasService;
	
	@RequestMapping("/nova")
	public ModelAndView nova(ModelAndView mv){
		mv.setViewName(VIEW_CADASTRO);
		mv.addObject(new Despesa());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listagem(ModelAndView mv){
		mv.setViewName(VIEW_LISTAGEM);
		mv.addObject("listaDespesas", despesasService.listarDespesas());
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(@Valid @ModelAttribute("despesa") Despesa despesa, ModelAndView mv, Errors errors){
		mv.setViewName(VIEW_CADASTRO);
		
		if(errors.hasErrors()){
			return mv;
		}
		
		despesasService.salvar(despesa);
		
		mv.addObject("mensagem", "Despesa criada com sucesso");
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo){
		despesasService.deletarPorCodigo(codigo);
		return VIEW_LISTAGEM;
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias(){
		return Arrays.asList(Categoria.values());
	}
}
