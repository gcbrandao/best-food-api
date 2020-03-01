package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    Optional<Restaurante> findFirstByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);
}
