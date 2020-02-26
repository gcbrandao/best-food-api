package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> list();

    Cidade find(Long id);

    Cidade save(Cidade cidade);

    void remove(Cidade cidade);

}
