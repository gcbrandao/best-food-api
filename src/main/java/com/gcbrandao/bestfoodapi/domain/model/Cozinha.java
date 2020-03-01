package com.gcbrandao.bestfoodapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cozinha")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    //@JsonProperty("titulo") // para mudar somente o nome do atributo no retorno
    // @JsonIgnore // para ignorar a propriedade
    @Column(nullable = false)
    private String nome;

}
