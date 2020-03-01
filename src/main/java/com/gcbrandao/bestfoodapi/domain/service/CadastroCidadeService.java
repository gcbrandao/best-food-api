package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Cidade;
import com.gcbrandao.bestfoodapi.domain.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void delete(Long cidadeID) {

        Optional<Cidade> cidade = cidadeRepository.findById(cidadeID);

        if (cidade.isPresent()) {
            cidadeRepository.delete(cidade.get());
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Cidade com o ID %d não enconrtado", cidadeID));
        }
    }

    public Cidade update(Cidade cidade) {
        Optional<Cidade> cidadeOld = cidadeRepository.findById(cidade.getId());

        if (cidadeOld.isPresent()) {
            BeanUtils.copyProperties(cidade, cidadeOld.get(), "id");

            return cidadeRepository.save(cidadeOld.get());
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Cidade com o ID %d não enconrada!!", cidade.getId()));
        }
    }

    public List<Cidade> list() {
        return cidadeRepository.findAll();
    }

    public Cidade buscar(Long cidadeID) {

        Optional<Cidade> cidade = cidadeRepository.findById(cidadeID);
        if (cidade.isPresent()) {
            return cidade.get();
        }
        throw new EntidadeNaoEncontradaException(String.format("Cidade com ID %d não encontrado !!!", cidadeID));

    }

}
