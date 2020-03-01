package com.gcbrandao.bestfoodapi.domain.repository;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
