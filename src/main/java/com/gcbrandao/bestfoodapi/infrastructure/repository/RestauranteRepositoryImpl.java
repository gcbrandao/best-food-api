package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurante> find(String nome, BigDecimal taxaInicio, BigDecimal taxaFim){
        var jpql =  new StringBuilder();

        var parametros = new HashMap<String, Object>();

        jpql.append("from Restaurante where 0 = 0 ");

        if (StringUtils.hasLength(nome)){
            jpql.append(" and nome like :nome ");
            parametros.put("nome", "%" + nome + "%" );
        }
        if(taxaInicio != null){
            jpql.append(" and taxaFrete >= :taxaInicio ");
            parametros.put("taxaInicio", taxaInicio);
        }
        if(taxaFim != null){
            jpql.append(" and taxaFrete <= :taxaFim ");
            parametros.put("taxaFim", taxaFim);
        }

        TypedQuery<Restaurante> query = entityManager.createQuery(jpql.toString(), Restaurante.class);

        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }

}
