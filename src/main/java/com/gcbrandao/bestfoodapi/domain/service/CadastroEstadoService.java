package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Estado;
import com.gcbrandao.bestfoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroEstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void delete(Long estadoID) {

        Estado estado = estadoRepository.find(estadoID);

        if (estado != null) {
            estadoRepository.remove(estado);
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Estado com o ID %d não enconrtado", estadoID));
        }
    }

    public Estado update(Estado estado) {
        Estado estadoOld = estadoRepository.find(estado.getId());

        if (estadoOld != null) {
            BeanUtils.copyProperties(estado, estadoOld, "id");

            return estadoRepository.save(estadoOld);
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Estado com o ID %d não enconrado!!", estado.getId()));
        }
    }

    public List<Estado> list(){
        return estadoRepository.list();
    }

    public Estado buscar(Long estadoID){

        Estado estado = estadoRepository.find(estadoID);
        if (estado != null){
            return estado;
        }
        throw new EntidadeNaoEncontradaException(String.format("Estado com ID %d não encontrado !!!", estadoID));

    }

}
