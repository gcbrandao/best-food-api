package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.domain.model.Cidade;
import com.gcbrandao.bestfoodapi.domain.repository.CidadeRepository;
import com.gcbrandao.bestfoodapi.domain.service.CadastroCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    CadastroCidadeService cadastroCidadeService;


    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {

        return ResponseEntity.status(HttpStatus.OK).body(cadastroCidadeService.list());
    }

    @GetMapping("/{cidadeID}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeID) {

        Cidade cidade = cadastroCidadeService.buscar(cidadeID);
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();

    }


    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        Cidade cidadeSaved = cidadeRepository.save(cidade);

        return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
    }

    @DeleteMapping("/{cidadeID}")
    public ResponseEntity<Cidade> delete(@PathVariable Long cidadeID) {
        Cidade cidade = cidadeRepository.find(cidadeID);
        return ResponseEntity.noContent().build();
    }
}
