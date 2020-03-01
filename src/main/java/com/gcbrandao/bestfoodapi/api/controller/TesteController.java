package com.gcbrandao.bestfoodapi.api.controller;


import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.CozinhaRepository;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    CozinhaRepository cozinhaRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/busca-por-nome")
    public List<Cozinha> findByName(@RequestParam("nome") String nome){
        return cozinhaRepository.findByNomeContaining(nome);

    }

    @GetMapping("/restaurantes/busca-top2-por-nome")
    public List<Restaurante> findTop2ByName(@RequestParam("nome") String nome){
        return restauranteRepository.findTop2ByNomeContaining(nome);

    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante>  findByTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal){
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> findFirstByName(String nome){
        return restauranteRepository.findFirstByNomeContaining(nome);
    }

}
