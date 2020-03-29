package com.lojacarro.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lojacarro.demo.model.Carro;
import com.lojacarro.demo.repository.ICarro;

@Controller
public class Controle {
	
	private ICarro iCarro;
	
	Controle(ICarro icarro) {
		this.iCarro = icarro;
	}
	
	@RequestMapping(value="/home")
	public String getCarros(Model model) {
		List<Carro> carros = iCarro.findAll();
		model.addAttribute("carros", carros);
		return "index";
	}
	
	@RequestMapping(value="/new")
	public String Salvar(Model model) {
		model.addAttribute("carro", new Carro());
		return "form";
	}
	
	@PostMapping(value="/save")
	public String save(@Valid Carro c, Model model) {
		iCarro.save(c);
		return "redirect:/home";
	}
	
	@GetMapping(value="/editar/{id}")
	public String Editar(@PathVariable int id, Model model) {
		Optional<Carro> carro = iCarro.findById(id);
		model.addAttribute("carro", carro);
		return "form";
	}
	
	@GetMapping(value="/deletar/{id}")
	public String Deletar(@PathVariable int id, Model model) {
		iCarro.deleteById(id);
		return "redirect:/home";
	}
}
