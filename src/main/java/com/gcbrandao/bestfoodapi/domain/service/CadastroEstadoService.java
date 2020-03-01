package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Estado;
import com.gcbrandao.bestfoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroEstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void delete(Long estadoID) {

        Estado estado = estadoRepository.findById(estadoID)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Estado com o ID %d não enconrtado", estadoID)));

        estadoRepository.delete(estado);
    }

    public Estado update(Estado estado) {
        Estado estadoOld = estadoRepository.findById(estado.getId())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Estado com o ID %d não enconrado!!", estado.getId())));

        BeanUtils.copyProperties(estado, estadoOld, "id");

        return estadoRepository.save(estadoOld);
    }

    public List<Estado> list() {
        return estadoRepository.findAll();
    }

    public Estado buscar(Long estadoID) {

        Optional<Estado> estado = estadoRepository.findById(estadoID);
        if (estado.isPresent()) {
            return estado.get();
        }
        throw new EntidadeNaoEncontradaException(String.format("Estado com ID %d não encontrado !!!", estadoID));

    }

}
