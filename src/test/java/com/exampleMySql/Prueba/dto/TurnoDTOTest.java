package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Domicilio;
import com.exampleMySql.Prueba.model.Odontologo;
import com.exampleMySql.Prueba.model.Paciente;
import com.exampleMySql.Prueba.model.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoDTOTest {

    TurnoDTO turnoDTO;
    private Odontologo odontologo;
    private Paciente paciente;

    @BeforeEach
    @DisplayName("turnoDTO")
    void SetUp(){
        turnoDTO = new TurnoDTO();
        odontologo = new Odontologo();
        paciente =new Paciente();
    }

    @Test
    void getSetId() {
        turnoDTO.setId(1L);
        Assertions.assertNotNull(turnoDTO.getId());
        Assertions.assertEquals(1L, turnoDTO.getId());
    }

    @Test
    void getSetPaciente() {
        Domicilio domicilio = new Domicilio();
        LocalDateTime fechaYHora = LocalDateTime.now();

        paciente.setId(1L);
        paciente.setDni(258);
        paciente.setNombre("Cleri");
        paciente.setApellido("Mora");
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");
        paciente.setDomicilio(domicilio);
        paciente.setTurnos(null);
        paciente.setFechaAlta(fechaYHora);

        turnoDTO.setPaciente(paciente);

        Assertions.assertNotNull(paciente);
        Assertions.assertEquals(paciente, turnoDTO.getPaciente());
    }

    @Test
    void getSetOdontologo() {

        LocalDateTime fechaYHora = LocalDateTime.now();

        odontologo.setId(1L);
        odontologo.setMatricula("1234");
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setTurnos(null);
        odontologo.setFechaIngreso(fechaYHora);

        turnoDTO.setOdontologo(odontologo);

        Assertions.assertNotNull(odontologo);
        Assertions.assertEquals(odontologo, turnoDTO.getOdontologo());
    }

    @Test
    void getSetFechaHora() {
        LocalDateTime localDateTime = LocalDateTime.now();

        turnoDTO.setFechaHora(localDateTime);
        Assertions.assertNotNull(localDateTime);
        Assertions.assertEquals(localDateTime, turnoDTO.getFechaHora());
    }


    @Test
    void builder() {
        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        Paciente paciente = new Paciente();
        Domicilio domicilio = new Domicilio();
        Odontologo odontologo = new Odontologo();


        var TurnoDTO= turnoDTO.builder();

        odontologo.setId(1L);
        odontologo.setMatricula("1234");
        odontologo.setNombre("Cleri");
        odontologo.setApellido("Mora");
        odontologo.setTurnos(null);
        odontologo.setFechaIngreso(fechaYHora);

        paciente.setId(1L);
        paciente.setDni(258);
        paciente.setNombre("Cleri");
        paciente.setApellido("Mora");
        paciente.setDomicilio(domicilio);
        paciente.setTurnos(null);
        paciente.setFechaAlta(fechaYHora);
        domicilio.setCalle("pacheco");
        domicilio.setAltura(1512);
        domicilio.setCiudad("Buenos aires");
        domicilio.setPais("Argentina");

        turnoDTO.setId(1L);
        turnoDTO.setPaciente(paciente);
        turnoDTO.setOdontologo(odontologo);
        turnoDTO.setFechaHora(fechaYHora);
        TurnoDTO.build();

        Assertions.assertEquals(1, turnoDTO.getId());
        Assertions.assertEquals(paciente, turnoDTO.getPaciente());
        Assertions.assertEquals(odontologo, turnoDTO.getOdontologo());
        Assertions.assertEquals(fechaYHora, turnoDTO.getFechaHora());
    }
}