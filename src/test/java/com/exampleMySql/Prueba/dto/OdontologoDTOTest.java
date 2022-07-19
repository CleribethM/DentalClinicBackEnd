package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Odontologo;
import com.exampleMySql.Prueba.model.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

class OdontologoDTOTest {

    @Test
    void getId() {
        //arrange
        OdontologoDTO odontologoDTO= new OdontologoDTO();
        //
        odontologoDTO.setId(1L);
        //assert
        Assertions.assertEquals(1L, odontologoDTO.getId());
    }

    @Test
    void getSetNombre() {
        //arrange
        OdontologoDTO odontologoDTO= new OdontologoDTO();
        //Act
        odontologoDTO.setNombre("Cleri");
        //assert
        Assertions.assertEquals("Cleri", odontologoDTO.getNombre());
    }

    @Test
    void getSetApellido() {
        //arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        //Act
        odontologoDTO.setApellido("Mora");
        //assert
        Assertions.assertEquals("Mora", odontologoDTO.getApellido());
    }

    @Test
    void getSetMatricula() {
        //arrange
        OdontologoDTO odontologoDTO= new OdontologoDTO();
        //Act
        odontologoDTO.setMatricula("C1607O");
        //assert
        Assertions.assertEquals("C1607O", odontologoDTO.getMatricula());
    }

    @Test
    void getSetFechaIngreso() {
        //arrange
        OdontologoDTO odontologoDTO= new OdontologoDTO();
        //Act
        LocalDateTime fechaYhora= LocalDateTime.now();
        odontologoDTO.setFechaIngreso(fechaYhora);
        //assert
        Assertions.assertEquals(fechaYhora, odontologoDTO.getFechaIngreso());
    }

    @Test
    void testToString() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Set<Turno> turnos = new HashSet<Turno>();
        OdontologoDTO odontologoDTO = new OdontologoDTO(1L,  "Cleri", "Mora", "1234", timestamp.toLocalDateTime());

        Assertions.assertNotNull(odontologoDTO.toString());
        Assertions.assertNotNull(odontologoDTO);
    }

    @Test
    void builder() {
        //Arrange
        LocalDateTime fechaYHora = LocalDateTime.now();
        OdontologoDTO odontologoDTO = new OdontologoDTO();


        var OdontologoDTO= odontologoDTO.builder();
        odontologoDTO.setId(1L);
        odontologoDTO.setMatricula("1234");
        odontologoDTO.setNombre("Cleri");
        odontologoDTO.setApellido("Mora");
        odontologoDTO.setFechaIngreso(fechaYHora);
        OdontologoDTO.build();

        Assertions.assertEquals(1, odontologoDTO.getId());
        Assertions.assertEquals("1234", odontologoDTO.getMatricula());
        Assertions.assertEquals("Cleri", odontologoDTO.getNombre());
        Assertions.assertEquals("Mora", odontologoDTO.getApellido());
        Assertions.assertEquals(fechaYHora, odontologoDTO.getFechaIngreso());
    }

}