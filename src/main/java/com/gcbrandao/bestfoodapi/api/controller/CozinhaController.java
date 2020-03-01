package com.gcbrandao.bestfoodapi.api.controller;

import com.gcbrandao.bestfoodapi.api.model.CozinhaXMLWrapper;
import com.gcbrandao.bestfoodapi.domain.exception.EntidadeEmUsoException;
import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.repository.CozinhaRepository;
import com.gcbrandao.bestfoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }


    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXMLWrapper listarXML() {
        return new CozinhaXMLWrapper(cozinhaRepository.findAll());
    }

    @GetMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
        Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);

        if (cozinha.isPresent()) {
            //return  ResponseEntity.status(HttpStatus.OK).body(cozinha);
            return ResponseEntity.ok(cozinha.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha add(@RequestBody Cozinha cozinha) {
        return cadastroCozinhaService.save(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    ResponseEntity<Cozinha> update(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha) {
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);

        if (cozinhaAtual.isPresent()) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
            Cozinha cozinhaSalva = cadastroCozinhaService.save(cozinhaAtual.get());
            return ResponseEntity.ok(cozinhaSalva);

        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remove(@PathVariable Long cozinhaId) {

        try {

            cadastroCozinhaService.excluir(cozinhaId);

            return ResponseEntity.noContent().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        }

    }


}
