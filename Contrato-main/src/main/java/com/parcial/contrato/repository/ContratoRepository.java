package com.parcial.contrato.repository;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.parcial.contrato.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato,Long>{
    Optional<Contrato> findById(Long id);
}
