package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> list();
    Cozinha find(Long id);
    Cozinha save(Cozinha cozinha);
    void remove(Long id);

}
