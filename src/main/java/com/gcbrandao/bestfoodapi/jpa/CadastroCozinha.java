package com.gcbrandao.bestfoodapi.jpa;


import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    EntityManager manager;

    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query =  manager.createQuery("from Cozinha", Cozinha.class);

        return query.getResultList();
    }

    @Transactional
    public Cozinha addCozinha(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    public Cozinha find(Long id){
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    public void remove(Cozinha cozinha){
        cozinha = find(cozinha.getId());
        manager.remove(cozinha);
    }
}
