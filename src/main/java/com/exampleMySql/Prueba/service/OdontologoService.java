package com.exampleMySql.Prueba.service;

import com.exampleMySql.Prueba.dto.OdontologoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Odontologo;

import com.exampleMySql.Prueba.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements InterfaceOdontologoService {


    private final OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    //Esta capa va a ser la que se encargara de transformar los dtos en las clases de negocio

    @Autowired
    ObjectMapper mapper;


    private Optional<Odontologo> guardarOdontologo(OdontologoDTO odontologoDTO){
        //Lo que debemos hacer es mappear nuestro odontologoDTO y transformarlo a un objeto de tipo odontologo que es lo que
        //queremos guardar
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return Optional.of(odontologoRepository.save(odontologo));

    }

    @Override
    public Optional<Odontologo> crearOdontologo(OdontologoDTO odontologoDTO) {
        //guarda un odontologo en la base de datos
       return guardarOdontologo(odontologoDTO);
    }

    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) throws BadRequestException{
        //Utilizamos un optional ya que esto nos va a decir si es nulo o no
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isEmpty())
            throw new BadRequestException("No existe un odontologo con el ID: "+id);

        return odontologo;
    }

    @Override
    public Set<OdontologoDTO> obtenerOdontologos() {
        //tenemos la lsta de odontologo y por cada odontologo lo que vamos a hacer es llenar otra lista, que seria
        //el set que vamos a devolver
      List<Odontologo> odontologos = odontologoRepository.findAll();
      Set<OdontologoDTO> odontologosDTO = new HashSet<>();

      //recorremos la lista y lo agregamos al set
        for (Odontologo odontologo: odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public Optional<Odontologo> modificarOdontologo(OdontologoDTO odontologoDTO) throws ResourceNotFoundException, BadRequestException {
        if(buscarOdontologo(odontologoDTO.getId()).isEmpty()){
            throw new ResourceNotFoundException("No existe un paciente con el ID: "+odontologoDTO.getId());
        }
        return guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(odontologo.isEmpty()) {
            throw new ResourceNotFoundException("No existe un odontologo con el ID "+id);
        }
        odontologoRepository.deleteById(id);
    }
/*
    @Override
    public Optional<Odontologo> buscarOdontologoNombre(String nombre) throws BadRequestException{
        Optional<Odontologo> odontologo = odontologoRepository.buscarOdontologoNombre(nombre);

        if (odontologo.isEmpty()){
            throw new BadRequestException("No existe un odontologo con el nombre "+ nombre);
        }
        return odontologo;
    }
*/

}
