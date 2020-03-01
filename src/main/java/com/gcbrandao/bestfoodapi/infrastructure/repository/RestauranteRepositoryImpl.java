package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurante> find(String nome, BigDecimal taxaInicio, BigDecimal taxaFim){
        var jpql = "from Restaurante where nome like :nome " +
                "and taxaFrete between :taxaInicial and :taxaFinal";

        return entityManager.createQuery(jpql, Restaurante.class)
                .setParameter("nome", "%" + nome + "%")
                .setParameter("taxaInicial", taxaInicio)
                .setParameter("taxaFinal", taxaFim)
                .getResultList();
    }

}
