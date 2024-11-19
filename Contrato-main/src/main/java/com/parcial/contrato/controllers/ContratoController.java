package com.parcial.contrato.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.contrato.services.ContratoService;
import com.parcial.contrato.dto.ContratoDto;

@RestController
@RequestMapping("/api/contrato")
@CrossOrigin
@Validated
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    // Listar todos los usuarios
    @GetMapping("/list")
    public ResponseEntity<List<ContratoDto>> get() {
        try {
            List<ContratoDto> contratos = contratoService.list();
            return new ResponseEntity<>(contratos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener usuario por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ContratoDto> get(@PathVariable Long id) {
        try {
            ContratoDto contrato = contratoService.get(id);
            if (contrato != null) {
                return new ResponseEntity<>(contrato, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Crear un nuevo contrato
    @PostMapping("/create")
    public ResponseEntity<ContratoDto> save(@Valid @RequestBody ContratoDto contratoDto) {
        try {
            ContratoDto contratoCreado = contratoService.saveNew(contratoDto);
            return new ResponseEntity<>(contratoCreado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un contrato previamente existente
    @PutMapping("/update")
    public ResponseEntity<ContratoDto> update(@Valid @RequestBody ContratoDto contratoDto) {
        try {
            ContratoDto contratoActualizado = contratoService.save(contratoDto);
            return new ResponseEntity<>(contratoActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un contrato
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@Valid @RequestBody ContratoDto contratoDto) {
        try {
            contratoService.delete(contratoDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    
}
