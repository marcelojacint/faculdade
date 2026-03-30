package com.hotel.domain.entity;

import com.hotel.domain.enums.StatusQuarto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Quarto")
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String andar;
    private StatusQuarto status;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private TipoQuarto tipo;
}
