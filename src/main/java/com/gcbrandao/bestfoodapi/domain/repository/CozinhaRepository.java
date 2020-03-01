package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

   // List<Cozinha> findByName(String nome);
}
