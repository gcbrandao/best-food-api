package com.gcbrandao.bestfoodapi.domain.service;

import com.gcbrandao.bestfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.gcbrandao.bestfoodapi.domain.model.Cidade;
import com.gcbrandao.bestfoodapi.domain.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroCidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void delete(Long cidadeID) {

        Cidade cidade = cidadeRepository.find(cidadeID);

        if (cidade != null) {
            cidadeRepository.remove(cidade);
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Cidade com o ID %d não enconrtado", cidadeID));
        }
    }

    public Cidade update(Cidade cidade) {
        Cidade cidadeOld = cidadeRepository.find(cidade.getId());

        if (cidadeOld != null) {
            BeanUtils.copyProperties(cidade, cidadeOld, "id");

            return cidadeRepository.save(cidadeOld);
        } else {
            throw new EntidadeNaoEncontradaException(String.format("Cidade com o ID %d não enconrada!!", cidade.getId()));
        }
    }

    public List<Cidade> list() {
        return cidadeRepository.list();
    }

    public Cidade buscar(Long cidadeID) {

        Cidade cidade = cidadeRepository.find(cidadeID);
        if (cidade != null) {
            return cidade;
        }
        throw new EntidadeNaoEncontradaException(String.format("Cidade com ID %d não encontrado !!!", cidadeID));

    }

}
