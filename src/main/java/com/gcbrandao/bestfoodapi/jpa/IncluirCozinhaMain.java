package com.gcbrandao.bestfoodapi.jpa;

import com.gcbrandao.bestfoodapi.BestFoodApiApplication;
import com.gcbrandao.bestfoodapi.domain.model.Cozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class IncluirCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(BestFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        Cozinha cozinha = new Cozinha();
        cozinha.setNome("Brasileira");

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Japa");


        CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

        cadastroCozinha.addCozinha(cozinha);
        cadastroCozinha.addCozinha(cozinha2);
    }
}
