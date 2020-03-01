package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {


    @PersistenceContext
    EntityManager manager;


    @Override
    public List<Cozinha> list() {
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

    @Override
    public Cozinha find(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Override
    public List<Cozinha> findByName(String nome) {
//        return manager.createQuery("from Cozinha where nome = :nome", Cozinha.class)
//                .setParameter("nome", nome).getResultList();
        return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%").getResultList();
    }

    @Override
    @Transactional
    public Cozinha save(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        Cozinha cozinha = find(id);
        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }

}
