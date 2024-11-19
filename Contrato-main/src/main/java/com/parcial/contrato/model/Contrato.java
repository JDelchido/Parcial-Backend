package com.parcial.contrato.model;

import java.util.List;
import java.util.Date;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID contrato
    private String documentoContratado; //Documento del contratado
    private String documentoContratante; //Documento del contratante

    @Column(name = "nombre contratado", nullable = false, length = 255)
    private String nombreContratado; // Nombre del contratado

    @Column(name = "nombre contratante", nullable = false, length = 255)
    private String nombreContratante; // Nombre del contratante

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false) 
    private Date fechaFin;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (nombreContratado == null || nombreContratado.isEmpty()) {
            throw new IllegalArgumentException("El correo no puede estar vacío.");
        }
        if (nombreContratante == null || nombreContratante.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
    }

    public void registrarContrato(String nombreContratado, String documentoContratado, String nombreContratante, String documentoContratante, 
Date fechaInicio, Date fechaFin) {
        this.nombreContratado = nombreContratado;
        this.documentoContratado = documentoContratado;
        this.nombreContratante = nombreContratante;
        this.documentoContratante = documentoContratante;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }


    public void validar() {
        validate();
    }


}
