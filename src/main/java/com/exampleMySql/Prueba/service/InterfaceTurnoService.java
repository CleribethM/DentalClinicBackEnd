package com.exampleMySql.Prueba.service;

import com.exampleMySql.Prueba.dto.TurnoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Turno;

import java.util.Optional;
import java.util.Set;

public interface InterfaceTurnoService {

    Optional<Turno> crearTurno(TurnoDTO turnoDTO);
    Optional<Turno> buscarTurno(Long id) throws BadRequestException;
    Set<TurnoDTO> obtenerTurnos();
    Optional<Turno> modificarTuno(TurnoDTO turnoDTO) throws ResourceNotFoundException, BadRequestException;
    void cancelarTurno(Long id) throws ResourceNotFoundException;

}
