package com.eventosapp.eventosapp.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.mapping.PrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.eventosapp.eventosapp.models.Convidado;
import com.eventosapp.eventosapp.models.Evento;
import com.eventosapp.eventosapp.repositorio.ConvidadoPaginacao;
import com.eventosapp.eventosapp.repositorio.ConvidadoRepository;
import com.eventosapp.eventosapp.repositorio.EventoPaginacao;
import com.eventosapp.eventosapp.repositorio.EventoRepository;

@Controller
public class EventoController {
	
	@Autowired //Anotação que faz injeção de dependencias, ou seja, toda vez que for chamada, será instanciada automaticamente;
	private EventoRepository er;
	
	@Autowired //Anotação que faz injeção de dependencias, ou seja, toda vez que for chamada, será instanciada automaticamente;
	private ConvidadoRepository cr;
		
	@Autowired
	private ConvidadoPaginacao cp;
	
	@Autowired
	private EventoPaginacao ep;
	
	
	@RequestMapping(value="/cadastrar/evento", method=RequestMethod.GET)
	public String form() {
		return "evento";
	}
	
	@RequestMapping(value="/cadastrar/evento", method=RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result, RedirectAttributes attributes ) {
		System.out.println(evento);
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", " Campos vazios, favor preencher corretamente! ");
			//System.out.println("Erro ao tentar salvar dados de evento!");
		}else {
			er.save(evento); //persistindo os dados utilizando a classe
			attributes.addFlashAttribute("mensagem", " Cadastro feito com sucesso! ");
		}
			return "evento";
	}
	
	@RequestMapping(value="/lista/evento", method=RequestMethod.GET)
	public String listaEventos(HttpServletRequest request, Model model) {		
		
		int page = 0; //default page number is 0 (yes it is weird)
        int size = 3; //default page size is 10
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        
        model.addAttribute("eventos", ep.findAll(PageRequest.of(page, size)));      
        System.out.println("--->" + ep);
		
		return "listaEvento" ;
		
	}		
	
	
	
	@RequestMapping(value="lista/evento/{cod}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable ("cod") long cod) {
		
		Evento evento = er.findByCod(cod);
		System.out.println(evento);
		ModelAndView mv = new ModelAndView("detalhesEvento");
		mv.addObject("evento", evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);
		
		return mv;
	}
	
	
	
	@RequestMapping(value="lista/evento/{cod}", method=RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable ("cod") long cod, @Valid Evento evento, BindingResult result, RedirectAttributes attributes) {
			
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
		}
		else {
			//System.out.println("----->Evento:" + evento);			
			er.save(evento);					
			attributes.addFlashAttribute("mensagem","Cadastro realizado com êxito!");
		}		
		return "redirect:lista/evento";
	}
	
	
	/*@RequestMapping(value="lista/convidado/{cod}", method=RequestMethod.GET)
	public ModelAndView detalhesConvidado( @PathVariable ("cod") long cod, Model model) {
		
		Evento evento = er.findByCod(cod);
		System.out.println("----------->" + evento + "---> " + evento.getCod());
		ModelAndView mv = new ModelAndView("detalhesConvidado");
		mv.addObject("evento", evento);
		
		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);    
		
		
		return mv;
	}*/
	        
	
	@RequestMapping(value = "lista/convidado/{cod}", method = RequestMethod.GET )
	public String detalhesConvidado(@PathVariable ("cod") long cod, HttpServletRequest request, Model model) {
		
		Evento evento = er.findByCod(cod);		
		List<Convidado> convidados= evento.getConvidado(); //pegar convidados APENAS do evento selecionado
		
		int page = 0; //default page number is 0 (yes it is weird)
        int size = 3; //default page size is 10
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        
        model.addAttribute("convidados", convidados);
        model.addAttribute("evento", evento );
        model.addAttribute("convidado", cp.findAll(PageRequest.of(page, size)));      
        System.out.println("--->" + evento.getConvidado().toString());
		
		return "detalhesConvidado" ;
		
	}
		
	
	@RequestMapping(value="lista/convidado/{cod}", method=RequestMethod.POST)
	public String detalhesParticipante (@PathVariable ("cod") long cod,  @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
		
		Evento evento = er.findByCod(cod);			
		System.out.println("CONVIDADO: " + convidado);
		try {
			if (result.hasErrors()) {
				attributes.addFlashAttribute("mensagem", "Algo está faltando! Por favor, verifique os campos!");
			}
			else {
				convidado.setEvento(evento);
				cr.save(convidado);	
				er.save(evento);			
				attributes.addFlashAttribute("mensagem","Cadastro realizado com êxito!");
			}		
		} catch (Exception e) {			
			attributes.addFlashAttribute("mensagem","Este RG já está em uso!");			
		}	
		return "redirect:lista/convidado/{cod}";
	}
	
	@RequestMapping("/deletarConvidado")
	public String  deletarConvidado(long id) {
		
		Convidado convidado = cr.findById(id);
		cr.delete(convidado);		
		Evento evento = convidado.getEvento(); //acessar codigo do evento
		long codigoEvento = evento.getCod();
		String codEv = "" + codigoEvento;
		return "redirect:lista/convidado/" + codEv;
		
	}
	
	@RequestMapping("/deletarEvento")
	public String deletarEvento(long cod) {
		
		Evento evento = er.findByCod(cod);		
		System.out.println(evento);		
		er.delete(evento);
		return "redirect:lista/evento";
	 }
}//fim EventoController

