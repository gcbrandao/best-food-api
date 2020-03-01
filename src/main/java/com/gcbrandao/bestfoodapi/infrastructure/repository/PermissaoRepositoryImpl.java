package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.Permissao;
import com.gcbrandao.bestfoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PermissaoRepositoryImpl implements PermissaoRepository {


    @PersistenceContext
    EntityManager manager;


    @Override
    public List<Permissao> list() {
        TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);

        return query.getResultList();
    }

    @Override
    public Permissao find(Long id) {
        return manager.find(Permissao.class, id);
    }

    @Override
    @Transactional
    public Permissao save(Permissao permissao) {
        return manager.merge(permissao);
    }

    @Override
    @Transactional
    public void remove(Permissao permissao) {
        permissao = find(permissao.getId());
        manager.remove(permissao);
    }

}
