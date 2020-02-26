package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> list();

    Restaurante find(Long id);

    Restaurante save(Restaurante restaurante);

    void remove(Restaurante restaurante);
}
