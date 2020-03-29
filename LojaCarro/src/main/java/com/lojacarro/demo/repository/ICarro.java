package com.lojacarro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojacarro.demo.model.Carro;

@Repository
public interface ICarro extends JpaRepository<Carro, Integer>{

}
