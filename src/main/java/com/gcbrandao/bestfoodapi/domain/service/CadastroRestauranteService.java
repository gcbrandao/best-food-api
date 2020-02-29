package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.CozinhaRepository;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CozinhaRepository cozinhaRepository;


    public Restaurante save(Restaurante restaurante){

        Long cozinhaID = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.find(cozinhaID);

        if (cozinha == null){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro da cozinha de codigo %d", cozinhaID));
        }
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }

    public Restaurante update(Restaurante restaurante){
        Long restauranteId = restaurante.getId();
        Restaurante restauranteOld = restauranteRepository.find(restauranteId);

        if(restauranteOld == null){
            throw new EntidadeNaoEncontradaException(String.format("Restaurante de ID %d não encontrado!!", restauranteId));
        }

        Long cozinhaID = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.find(cozinhaID);

        if (cozinha == null){
            throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro da cozinha de codigo %d", cozinhaID));
        }
        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }


}
