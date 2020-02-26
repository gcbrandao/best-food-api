package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> list();

    Permissao find(Long id);

    Permissao save(Permissao permissao);

    void remove(Permissao permissao);

}
