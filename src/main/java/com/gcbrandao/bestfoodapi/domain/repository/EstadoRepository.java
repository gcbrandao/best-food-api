package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> list();

    Estado find(Long id);

    Estado save(Estado estado);

    void remove(Estado estado);

}
