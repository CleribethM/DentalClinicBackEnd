package com.exampleMySql.Prueba.controller;


import com.exampleMySql.Prueba.dto.OdontologoDTO;
import com.exampleMySql.Prueba.exceptions.BadRequestException;
import com.exampleMySql.Prueba.exceptions.ResourceNotFoundException;
import com.exampleMySql.Prueba.model.Odontologo;
import com.exampleMySql.Prueba.service.InterfaceOdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final Logger logger = Logger.getLogger(OdontologoController.class);

    //Aca con esto, conectamos nuestro controller con nuestro servicio
    private final InterfaceOdontologoService odontologoService;

    @Autowired
    public OdontologoController(InterfaceOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //Ahora hacemos los metodos para los odontologos
    @PostMapping
    public ResponseEntity<HttpStatus> crearOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        logger.info("Se ha creado el odontologo");
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws BadRequestException {
        if(odontologoService.buscarOdontologo(id).isPresent()){
            logger.info("Se ha encontrado el odontologo por ID: "+id);
            return ResponseEntity.ok(odontologoService.buscarOdontologo(id).get());
        }
        else{
            logger.error("No se ha encontrado un odontologo con el ID: "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping
    public ResponseEntity<String> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException, BadRequestException {
        odontologoService.modificarOdontologo(odontologoDTO);
        logger.info("Se esta modificando al odontologo");
        return ResponseEntity.ok("Se ha podido modificar correctamente el Odontologo");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        logger.info("Se ha eliminado el odontologo con el ID: "+id);
        return ResponseEntity.ok("Odontologo Eliminado");
    }

    @GetMapping
    public Set<OdontologoDTO> listadoOdontologos(){
        logger.info("Se muestra la lista de odontologos");
       return odontologoService.obtenerOdontologos();
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarError400(BadRequestException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
/*
    @GetMapping("/{nombre}")
    public ResponseEntity buscarOdontologoNombre(@PathVariable String nombre) throws BadRequestException{

        if(odontologoService.buscarOdontologoNombre(nombre).isPresent()){
            logger.info("Se ha encontrado el odontologo "+nombre);
            return ResponseEntity.ok(odontologoService.buscarOdontologoNombre(nombre).get());
        }
        else{
            logger.error("No se ha encontrado un odontologo "+nombre);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }*/
}
