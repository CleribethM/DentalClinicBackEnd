package com.exampleMySql.Prueba.service;


import com.exampleMySql.Prueba.dto.PacienteDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Paciente;


import java.util.Optional;
import java.util.Set;

public interface InterfacePacienteService {

    Optional<Paciente> crearPaciente(PacienteDTO pacienteDTO);
    Optional<Paciente> buscarPaciente(Long id) throws BadRequestException;
    Set<PacienteDTO> obtenerPacientes();
    Optional<Paciente> modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException, BadRequestException;
    void eliminarPaciente(Long id) throws ResourceNotFoundException;

}
