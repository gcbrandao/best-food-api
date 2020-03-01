package com.gcbrandao.bestfoodapi.infrastructure.repository;

import com.gcbrandao.bestfoodapi.domain.model.FormaPagamento;
import com.gcbrandao.bestfoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {


    @PersistenceContext
    EntityManager manager;


    @Override
    public List<FormaPagamento> list() {
        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);

        return query.getResultList();
    }

    @Override
    public FormaPagamento find(Long id) {
        return manager.find(FormaPagamento.class, id);
    }

    @Override
    @Transactional
    public FormaPagamento save(FormaPagamento formaPagamento) {
        return manager.merge(formaPagamento);
    }

    @Override
    @Transactional
    public void remove(FormaPagamento formaPagamento) {
        formaPagamento = find(formaPagamento.getId());
        manager.remove(formaPagamento);
    }

}
