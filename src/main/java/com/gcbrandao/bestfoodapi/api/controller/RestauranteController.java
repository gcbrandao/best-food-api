package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping
    public ResponseEntity<List<Restaurante>> lista(){
        List<Restaurante> restauranteList = restauranteRepository.list();
        return ResponseEntity.ok(restauranteList);
    }

    @GetMapping("{restauranteId}")
    public ResponseEntity<Restaurante>  busca(@PathVariable Long restauranteId){
        Restaurante restaurante = restauranteRepository.find(restauranteId);
        if(restaurante != null){
            return ResponseEntity.ok(restaurante);
        }
            return ResponseEntity.notFound().build();
    }
}
