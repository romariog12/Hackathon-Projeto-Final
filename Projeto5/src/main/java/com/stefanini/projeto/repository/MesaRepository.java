package com.stefanini.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.projeto.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{
	Mesa findByNome(String nome);
	
}
