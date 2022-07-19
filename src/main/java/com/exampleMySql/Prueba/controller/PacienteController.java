package com.exampleMySql.Prueba.controller;

import com.exampleMySql.Prueba.dto.PacienteDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Paciente;
import com.exampleMySql.Prueba.service.InterfacePacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final Logger logger = Logger.getLogger(PacienteController.class);
    //Aca con esto, conectamos nuestro controller con nuestro servicio, TENGO QUE ARREGLARLO Y PONERLO DE LA MJOR FORMA

    private final InterfacePacienteService pacienteService;

    @Autowired
    public PacienteController(InterfacePacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Ahora hacemos los metodos para los pacientes
    @PostMapping
    public ResponseEntity<HttpStatus> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        logger.info("Se ha creado un nuevo paciente");
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) throws BadRequestException {
        if(pacienteService.buscarPaciente(id).isPresent()){
            logger.info("Se ha encontrado el paciente por ID: "+id);
            return ResponseEntity.ok(pacienteService.buscarPaciente(id).get());
        }
        else{
            logger.error("No se ha encontrado un paciente con el ID: "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException, BadRequestException {
        pacienteService.modificarPaciente(pacienteDTO);
        logger.info("Se ha modificado correctamente el paciente");
        return ResponseEntity.ok("Se ha podido modificar correctamente el Paciente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        logger.info("Se ha eliminado el paciente con el ID: "+id);
        return ResponseEntity.ok("Paciente Eliminado");
    }

    @GetMapping
    public Set<PacienteDTO> listadoPacientes(){
        logger.info("Se muestra el listado de pacientes");
        return pacienteService.obtenerPacientes();
    }

   @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarError400(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
