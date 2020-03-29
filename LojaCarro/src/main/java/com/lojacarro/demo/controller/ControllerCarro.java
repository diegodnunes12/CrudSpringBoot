package com.lojacarro.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lojacarro.demo.model.Carro;
import com.lojacarro.demo.repository.ICarro;

@RestController
@RequestMapping({"/carros"})
public class ControllerCarro {
	private ICarro iCarro;
	
	ControllerCarro(ICarro icarro) {
		this.iCarro = icarro;
	}
	
	@GetMapping
	public List findAll(){
	  return iCarro.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Carro> findById(@PathVariable int id){
	  return iCarro.findById(id)
	          .map(record -> ResponseEntity.ok().body(record))
	          .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Carro create(@RequestBody Carro carro){
	    return iCarro.save(carro);
	}
	
	@PutMapping(value="/{id}")
	  public ResponseEntity<Carro> update(@PathVariable("id") int id,
	                                        @RequestBody Carro carro){
	    return iCarro.findById(id)
	        .map(record -> {
	            record.setMarca(carro.getMarca());
	            record.setModelo(carro.getModelo());
	            Carro updated = iCarro.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
	@DeleteMapping(path ={"/{id}"})
	  public ResponseEntity<?> delete(@PathVariable("id") int id) {
	    return iCarro.findById(id)
	        .map(record -> {
	            iCarro.deleteById(id);
	            return ResponseEntity.ok().build();
	        }).orElse(ResponseEntity.notFound().build());
	  }
	
}
