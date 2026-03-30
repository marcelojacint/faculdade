package com.hotel.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TipoQuarto")
@NoArgsConstructor
@AllArgsConstructor
public class TipoQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    /*@OneToMany(mappedBy = "tipo")
private List<Quarto> quartos;*/
}
