package com.exampleMySql.Prueba.service;

import com.exampleMySql.Prueba.dto.OdontologoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Odontologo;



import java.util.Optional;
import java.util.Set;

public interface InterfaceOdontologoService {

    Optional<Odontologo> crearOdontologo(OdontologoDTO odontologoDTO);
    Optional<Odontologo> buscarOdontologo(Long id) throws BadRequestException;
    Set<OdontologoDTO> obtenerOdontologos();

    Optional<Odontologo> modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException, BadRequestException;;
    void eliminarOdontologo(Long id) throws ResourceNotFoundException;
/*
    Optional<Odontologo> buscarOdontologoNombre(String nombre) throws BadRequestException;
*/
}
