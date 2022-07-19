package com.exampleMySql.Prueba.service;

import com.exampleMySql.Prueba.dto.PacienteDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Paciente;
import com.exampleMySql.Prueba.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements InterfacePacienteService{


    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService( PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    @Autowired
    ObjectMapper mapper;

    private Optional<Paciente> guardarPaciente(PacienteDTO pacienteDTO){
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return Optional.of(pacienteRepository.save(paciente));
    }
    @Override
    public Optional<Paciente> crearPaciente(PacienteDTO pacienteDTO) {

        return guardarPaciente(pacienteDTO);
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) throws BadRequestException{

        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if (paciente.isEmpty()) {
            throw new BadRequestException("No existe un paciente con el ID: "+id);
        }
        return paciente;
    }

    @Override
    public Set<PacienteDTO> obtenerPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();

        //recorremos la lista y lo agregamos al set
        for (Paciente paciente: pacientes){
            pacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }


    public Optional<Paciente> modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException, BadRequestException {
       if(buscarPaciente(pacienteDTO.getId()).isEmpty()){
           throw new ResourceNotFoundException("No existe un paciente con el ID: "+pacienteDTO.getId());
       }
        return guardarPaciente(pacienteDTO);
    }


    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        Optional<Paciente> odontologo = pacienteRepository.findById(id);
            if(odontologo.isEmpty()) {
                throw new ResourceNotFoundException("No existe un paciente con el ID " + id);
            }
                 pacienteRepository.deleteById(id);
}


}
