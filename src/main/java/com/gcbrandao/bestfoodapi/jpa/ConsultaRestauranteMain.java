package com.gcbrandao.bestfoodapi.jpa;

import com.gcbrandao.bestfoodapi.BestFoodApiApplication;
import com.gcbrandao.bestfoodapi.domain.model.Restaurante;
import com.gcbrandao.bestfoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(BestFoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> lista = restauranteRepository.findAll();

        for (Restaurante restaurante : lista) {
            System.out.printf("%s - %f - %s     \n", restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
        }

        Optional<Restaurante> restauranteGet = restauranteRepository.findById(1L);
        System.out.println(restauranteGet.get().getNome());


    }
}
