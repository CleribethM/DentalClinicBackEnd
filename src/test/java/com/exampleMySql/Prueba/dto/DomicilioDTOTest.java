package com.exampleMySql.Prueba.dto;

import com.exampleMySql.Prueba.model.Domicilio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioDTOTest {

    @Test
    void getSetId() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();

        domicilioDTO.setId(1L);
        Assertions.assertNotNull(domicilioDTO.getId());
        Assertions.assertEquals(1L, domicilioDTO.getId());
    }

    @Test
    void getSetCalle() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();

        domicilioDTO.setCalle("Pacheco");
        Assertions.assertNotNull(domicilioDTO.getCalle());
        Assertions.assertEquals("Pacheco", domicilioDTO.getCalle());

    }

    @Test
    void getSetAltura() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();

        domicilioDTO.setAltura(1234);
        Assertions.assertNotNull(domicilioDTO.getAltura());
        Assertions.assertEquals(1234, domicilioDTO.getAltura());
    }

    @Test
    void getSetCiudad() {
        DomicilioDTO domicilioDTO= new DomicilioDTO();

        domicilioDTO.setCiudad("caba");
        Assertions.assertNotNull(domicilioDTO.getCiudad());
        Assertions.assertEquals("caba", domicilioDTO.getCiudad());
    }

    @Test
    void getSetPais() {
        Domicilio domicilio= new Domicilio();

        domicilio.setPais("Argentina");
        Assertions.assertNotNull(domicilio.getPais());
        Assertions.assertEquals("Argentina", domicilio.getPais());
    }

    @Test
    void testToString() {
        DomicilioDTO domicilioDTO = new DomicilioDTO(1L, "Pacheco", 124, "caba", "Argentina");

        Assertions.assertNotNull(domicilioDTO.toString());
        Assertions.assertNotNull(domicilioDTO);
    }


}