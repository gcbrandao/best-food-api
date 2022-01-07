package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    private static final String MSG_RESTAURANTE_NAO_ENCONTRADO
            = "Não existe um cadastro de restaurante com código %d";

    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinhaService.buscarOuFalhar(cozinhaId);

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }


    public Restaurante buscarOuFalhar(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
    }
}