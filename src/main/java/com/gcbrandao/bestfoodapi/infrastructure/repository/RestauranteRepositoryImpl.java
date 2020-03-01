package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    EntityManager manager;


    @Override
    public List<Restaurante> list() {
        TypedQuery<Restaurante> query = manager.createQuery("from Restaurante", Restaurante.class);

        return query.getResultList();
    }

    @Override
    public Restaurante find(Long id) {
        return manager.find(Restaurante.class, id);
    }

    @Override
    @Transactional
    public Restaurante save(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    @Transactional
    public void remove(Restaurante restaurante) {

        restaurante = find(restaurante.getId());
        manager.remove(restaurante);

    }
}
