package com.parcial.contrato;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.parcial.contrato.dto.ContratoDto;
import com.parcial.contrato.model.Contrato;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        // Mapeo para Usuario y UsuarioDto
        modelMapper.createTypeMap(Contrato.class, ContratoDto.class).addMappings(mapping -> {
            mapping.map(Contrato::getId, ContratoDto::setId);
            mapping.map(Contrato::getNombreContratado, ContratoDto::setNombreContratado);
            mapping.map(Contrato::getDocumentoContratado, ContratoDto::setDocumentoContratado);
            mapping.map(Contrato::getNombreContratante, ContratoDto::setNombreContratante);
            mapping.map(Contrato::getDocumentoContratante, ContratoDto::setDocumentoContratante);
            mapping.map(Contrato::getFechaInicio, ContratoDto::setFechaInicio);
            mapping.map(Contrato::getFechaFin, ContratoDto::setFechaFin);
        });

        modelMapper.createTypeMap(ContratoDto.class, Contrato.class).addMappings(mapping -> {
            mapping.map(ContratoDto::getId, Contrato::setId);
            mapping.map(ContratoDto::getNombreContratado, Contrato::setNombreContratado);
            mapping.map(ContratoDto::getDocumentoContratado, Contrato::setDocumentoContratado);
            mapping.map(ContratoDto::getNombreContratante, Contrato::setNombreContratante);
            mapping.map(ContratoDto::getDocumentoContratante, Contrato::setDocumentoContratante);
            mapping.map(ContratoDto::getFechaInicio, Contrato::setFechaInicio);
            mapping.map(ContratoDto::getFechaFin, Contrato::setFechaFin);
        });
        return modelMapper;
        }
}
