package com.techsmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsmart.model.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Integer> {

}
