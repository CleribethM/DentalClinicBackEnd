package com.exampleMySql.Prueba.controller;


import com.exampleMySql.Prueba.dto.TurnoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Turno;
import com.exampleMySql.Prueba.service.InterfaceTurnoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final Logger logger = Logger.getLogger(TurnoController.class);

    private final InterfaceTurnoService turnoService;

    @Autowired
    public TurnoController(InterfaceTurnoService turnoService) {
        this.turnoService = turnoService;
    }

    //Ahora hacemos los metodos para los turnos
    @PostMapping
    public ResponseEntity<HttpStatus> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        logger.info("Se ha creado un nuevo turno");
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurno(@PathVariable Long id) throws BadRequestException {

        if(turnoService.buscarTurno(id).isPresent()){
            logger.info("Se ha encontrado el turno con el ID: "+id);
            return ResponseEntity.ok(turnoService.buscarTurno(id).get());
        }else {
            logger.error("No se ha encontrado un turno con el ID: "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> modificarTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException, BadRequestException {
        turnoService.modificarTuno(turnoDTO);
        logger.info("Se ha modificado correctamente el turno");
        return ResponseEntity.ok("Se ha podido modificar correctamente el Turno");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException{
        turnoService.cancelarTurno(id);
        logger.info("Se ha eliminado el turno con el ID: "+id);
        return ResponseEntity.ok("Turno eliminado");
    }

    @GetMapping
    public Set<TurnoDTO> listadoDeTurnos(){
        logger.info("Se muestra el listado de turnos");
        return turnoService.obtenerTurnos();
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarError400(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
