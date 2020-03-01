package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Estado;
import com.gcbrandao.bestfoodapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {


    @PersistenceContext
    EntityManager manager;


    @Override
    public List<Estado> list() {
        TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);

        return query.getResultList();
    }

    @Override
    public Estado find(Long id) {
        return manager.find(Estado.class, id);
    }

    @Override
    @Transactional
    public Estado save(Estado estado) {
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void remove(Estado estado) {
        estado = find(estado.getId());
        manager.remove(estado);
    }

}
