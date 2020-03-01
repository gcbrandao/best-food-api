package com.gcbrandao.bestfoodapi.api.controller;


import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    CozinhaRepository cozinhaRepository;

//    @GetMapping("/cozinhas/busca-por-nome")
//    public List<Cozinha> findByName(@RequestParam("nome") String nome){
//        return cozinhaRepository.findByName(nome);
//
//    }

}
