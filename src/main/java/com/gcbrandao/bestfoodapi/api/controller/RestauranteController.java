package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import com.gcbrandao.bestfoodapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurante>> lista() {
        List<Restaurante> restauranteList = restauranteRepository.list();
        return ResponseEntity.ok(restauranteList);
    }

    @GetMapping("{restauranteId}")
    public ResponseEntity<Restaurante> busca(@PathVariable Long restauranteId) {
        Restaurante restaurante = restauranteRepository.find(restauranteId);
        if (restaurante != null) {
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {

        try {
            Restaurante restauranteSaved = cadastroRestauranteService.save(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restauranteSaved);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<?> update(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        try {
            Restaurante restauranteAtual = restauranteRepository.find(restauranteId);

            if (restauranteAtual != null) {
                BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

                restauranteAtual = cadastroRestauranteService.save(restauranteAtual);
                return ResponseEntity.ok(restauranteAtual);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}