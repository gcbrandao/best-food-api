package com.gcbrandao.bestfoodapi.jpa;

import com.gcbrandao.bestfoodapi.BestFoodApiApplication;
import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(BestFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);
        List<Cozinha> lista =  cadastroCozinha.listar();

        for (Cozinha cozinha: lista) {
            System.out.println(cozinha.getNome());
        }

        Cozinha cozinhaNew = cadastroCozinha.find(1L);
        System.out.println(cozinhaNew.getNome());


    }
}
