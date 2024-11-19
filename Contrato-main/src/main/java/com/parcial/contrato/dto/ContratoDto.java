package com.parcial.contrato.dto;

import java.util.Date;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID contrato
    private String nombreContratado; // Nombre del contratado
    private String documentoContratado; //Documento del contratado
    private String nombreContratante; // Nombre del contratante
    private String documentoContratante; //Documento del contratante
    private Date fechaInicio;
    private Date fechaFin;
}
