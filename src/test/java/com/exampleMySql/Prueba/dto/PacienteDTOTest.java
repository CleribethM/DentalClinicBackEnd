package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Domicilio;
import com.exampleMySql.Prueba.model.Odontologo;
import com.exampleMySql.Prueba.model.Paciente;
import com.exampleMySql.Prueba.model.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PacienteDTOTest {

    @Test
    void getId() {
        //arrange
        PacienteDTO pacienteDTO= new PacienteDTO();
        //Act
        pacienteDTO.setId(1L);
        //assert
        Assertions.assertEquals(1L, pacienteDTO.getId());
    }

    @Test
    void getNombre() {
        //arrange
        PacienteDTO pacienteDTO= new PacienteDTO();
        //Act
        pacienteDTO.setNombre("Cleri");
        //assert
        Assertions.assertEquals("Cleri", pacienteDTO.getNombre());
    }

    @Test
    void getApellido() {
        //arrange
        PacienteDTO pacienteDTO= new PacienteDTO();
        //Act
        pacienteDTO.setApellido("Mora");
        //assert
        Assertions.assertEquals("Mora", pacienteDTO.getApellido());
    }

    @Test
    void getDni() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        //Act
        pacienteDTO.setDni(95872503);
        //assert
        Assertions.assertEquals(95872503, pacienteDTO.getDni());
    }

    @Test
    void getFechaAlta() {
        //arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        LocalDateTime fechaYHora = LocalDateTime.now();
        //Act
        pacienteDTO.setFechaAlta(fechaYHora);
        //assert
        Assertions.assertEquals(fechaYHora, pacienteDTO.getFechaAlta());
    }

    @Test
    void getDomicilio() {
        PacienteDTO pacienteDTO= new PacienteDTO();
        Domicilio domicilio = new Domicilio();

        // act
        domicilio.setCalle("Pacheco");
        domicilio.setAltura(1522);
        domicilio.setCiudad("caba");
        domicilio.setPais("Argentina");
        pacienteDTO.setDomicilio(domicilio);

        // assert
        Assertions.assertEquals(domicilio, pacienteDTO.getDomicilio());
    }

    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio();
        LocalDateTime fechaAlta = LocalDateTime.now();
        PacienteDTO pacienteDTO = new PacienteDTO(1L,  "Cleri", "Mora", 95872503, fechaAlta, domicilio);

        Assertions.assertNotNull(pacienteDTO.toString());
        Assertions.assertNotNull(pacienteDTO);
    }

    @Test
    void builder() {

        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        PacienteDTO pacienteDTO = new PacienteDTO();
        Domicilio domicilio = new Domicilio();
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        Set<Turno> turnos = new HashSet<>();

        var PacienteDTO= pacienteDTO.builder();
        pacienteDTO.setId(1L);
        pacienteDTO.setDni(258);
        pacienteDTO.setNombre("Cleri");
        pacienteDTO.setApellido("Mora");
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");
        pacienteDTO.setDomicilio(domicilio);
        PacienteDTO.build();
        pacienteDTO.setFechaAlta(fechaYHora);

        Assertions.assertEquals(1, pacienteDTO.getId());
        Assertions.assertEquals(258, pacienteDTO.getDni());
        Assertions.assertEquals("Cleri", pacienteDTO.getNombre());
        Assertions.assertEquals("Mora", pacienteDTO.getApellido());
        Assertions.assertEquals(domicilio, pacienteDTO.getDomicilio());
        Assertions.assertEquals(fechaYHora, pacienteDTO.getFechaAlta());
    }
}