package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> list();

    FormaPagamento find(Long id);

    FormaPagamento save(FormaPagamento formaPagamento);

    void remove(FormaPagamento formaPagamento);

}
