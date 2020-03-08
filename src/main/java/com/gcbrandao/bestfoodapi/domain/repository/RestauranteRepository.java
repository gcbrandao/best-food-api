package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.infrastructure.repository.CustomJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long> {

    List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);

    Optional<Restaurante> findFirstByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    @Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
    List<Restaurante> buscaPorNome(String nome, @Param("id") Long cozinha);

    public List<Restaurante> find(String nome, BigDecimal taxaInicio, BigDecimal taxaFim);

    public List<Restaurante> findUsingAPI(String nome, BigDecimal taxaInicio, BigDecimal taxaFim);
}
