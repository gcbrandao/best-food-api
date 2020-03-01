package com.gcbrandao.bestfoodapi.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import com.gcbrandao.bestfoodapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurante>> lista() {
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        return ResponseEntity.ok(restauranteList);
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> busca(@PathVariable Long restauranteId) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
        if (restaurante.isPresent()) {
            return ResponseEntity.ok(restaurante.get());
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

    @PutMapping("/{restauranteID}")
    public ResponseEntity<?> update(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {
        try {
            Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

            if (restauranteAtual.isPresent()) {
                BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");

                Restaurante restauranteSave = cadastroRestauranteService.save(restauranteAtual.get());
                return ResponseEntity.ok(restauranteSave);
            }

            return ResponseEntity.notFound().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{restauranteID}")
    public ResponseEntity<?> updatePartial(@PathVariable Long restauranteID,
                                           @RequestBody Map<String, Object> campos) {
        Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteID);

        if (restauranteAtual.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        merge(campos, restauranteAtual.get());
        return update(restauranteID, restauranteAtual.get());
    }

    private void merge(@RequestBody Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {

        ObjectMapper objectMapper = new ObjectMapper();
        Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {

            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
            System.out.println(nomePropriedade + " = " + valorPropriedade);

            ReflectionUtils.setField(field, restauranteDestino, novoValor);

        });
    }

}
