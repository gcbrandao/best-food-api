package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cidade;
import com.gcbrandao.bestfoodapi.domain.repository.CidadeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {


    @PersistenceContext
    EntityManager manager;


    @Override
    public List<Cidade> list() {
        TypedQuery<Cidade> query = manager.createQuery("from Cidade", Cidade.class);

        return query.getResultList();
    }

    @Override
    public Cidade find(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade save(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    @Transactional
    public void remove(Cidade cidade) {
        cidade = find(cidade.getId());
        manager.remove(cidade);
    }

}
