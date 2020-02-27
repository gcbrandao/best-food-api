package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.domain.model.Estado;
import com.gcbrandao.bestfoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;


    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.list();
    }
}
