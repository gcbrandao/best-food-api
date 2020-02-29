package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.domain.model.Estado;
import com.gcbrandao.bestfoodapi.domain.repository.EstadoRepository;
import com.gcbrandao.bestfoodapi.domain.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CadastroEstadoService cadastroEstadoService;


    @GetMapping
    public ResponseEntity<List<Estado>> listar() {

        return ResponseEntity.status(HttpStatus.OK).body(cadastroEstadoService.list());
    }

    @GetMapping("{estadoID}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoID) {

        Estado estado = cadastroEstadoService.buscar(estadoID);
        if (estado != null) {
            return ResponseEntity.ok(estado);
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping
    public ResponseEntity<Estado> save(@RequestBody Estado estado) {
        Estado estadoSaved = estadoRepository.save(estado);

        return ResponseEntity.status(HttpStatus.CREATED).body(estado);
    }

    @DeleteMapping("estadoID")
    public void delete(@PathVariable Long estadoID) {
        Estado estado = estadoRepository.find(estadoID);

    }
}
