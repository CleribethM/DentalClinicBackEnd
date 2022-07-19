package com.exampleMySql.Prueba.service;

import com.exampleMySql.Prueba.dto.TurnoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Turno;
import com.exampleMySql.Prueba.repository.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements InterfaceTurnoService{


    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Autowired
    ObjectMapper mapper;


    private Optional<Turno> guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        return Optional.of(turnoRepository.save(turno));
    }

    @Override
    public Optional<Turno> crearTurno(TurnoDTO turnoDTO) {

        return guardarTurno(turnoDTO);
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) throws BadRequestException{
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isEmpty())
            //que convierta al odontologo a un objeto de tipo OdontologoDTO para que este sea el que retorne
            throw new BadRequestException("No existe un turno con el ID: "+id);

        return turno;
    }

    @Override
    public Set<TurnoDTO> obtenerTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO = new HashSet<>();

        //recorremos la lista y lo agregamos al set
        for (Turno turno: turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        }
        return turnosDTO;
    }

    @Override
    public Optional<Turno> modificarTuno(TurnoDTO turnoDTO) throws ResourceNotFoundException, BadRequestException {
        if(buscarTurno(turnoDTO.getId()).isEmpty()){
            throw new ResourceNotFoundException("No existe un turno con el ID: "+turnoDTO.getId());
        }
        return guardarTurno(turnoDTO);
    }

    @Override
    public void cancelarTurno(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);
        if(turno.isEmpty())
            throw new ResourceNotFoundException("No existe un turno con el ID: "+id);

        turnoRepository.deleteById(id);
    }
}
