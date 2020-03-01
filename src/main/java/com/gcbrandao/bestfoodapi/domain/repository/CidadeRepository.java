package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
