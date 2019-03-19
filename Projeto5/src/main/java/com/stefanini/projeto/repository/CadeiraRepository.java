package com.stefanini.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stefanini.projeto.model.Cadeira;

@Repository
public interface CadeiraRepository extends JpaRepository<Cadeira, Long>{

}
