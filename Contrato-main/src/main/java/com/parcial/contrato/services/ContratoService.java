package com.parcial.contrato.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.parcial.contrato.repository.ContratoRepository;
import com.parcial.contrato.model.Contrato;
import com.parcial.contrato.dto.ContratoDto;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Obtener un contrato por ID
    public ContratoDto get(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id);
                return contrato.map(value -> modelMapper.map(value, ContratoDto.class)).orElse(null);
    }

    // Listar todos los contratos
    public List<ContratoDto> list() {
        List<Contrato> contratos = contratoRepository.findAll();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDto.class))
                .collect(Collectors.toList());
    }

    // Guardar nuevo contrato (parte del registro)
    @Transactional
    public ContratoDto saveNew(ContratoDto contratoDto) {
        Contrato contrato = modelMapper.map(contratoDto, Contrato.class);
        contrato.validar();  // Validación de campos
        contrato = contratoRepository.save(contrato);  // Guardar nuevo usuario
        return modelMapper.map(contrato, ContratoDto.class);
    }

    // Actualizar contrato existente
    @Transactional
    public ContratoDto save(ContratoDto contratoDto) {
        Contrato contrato = modelMapper.map(contratoDto, Contrato.class);
        contrato = contratoRepository.save(contrato);// Actualizar el contrato existente
        return modelMapper.map(contrato, ContratoDto.class);
    }

    // Eliminar contrato
    @Transactional
    public void delete(ContratoDto contratoDto) {
        Contrato contrato = modelMapper.map(contratoDto, Contrato.class);
        contratoRepository.delete(contrato);  // Eliminación de forma lógica
    }


}
