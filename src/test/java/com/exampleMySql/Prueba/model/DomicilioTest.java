package com.exampleMySql.Prueba.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioTest {

    @Test
    void getIdDomicilio() {
        Domicilio domicilio= new Domicilio();

        domicilio.setIdDomicilio(1L);
        Assertions.assertNotNull(domicilio.getIdDomicilio());
        Assertions.assertEquals(1L, domicilio.getIdDomicilio());
    }

    @Test
    void getSetCalle() {

        Domicilio domicilio= new Domicilio();

        domicilio.setCalle("Pacheco");
        Assertions.assertNotNull(domicilio.getCalle());
        Assertions.assertEquals("Pacheco", domicilio.getCalle());

    }

    @Test
    void getAltura() {
        Domicilio domicilio= new Domicilio();

        domicilio.setAltura(1234);
        Assertions.assertNotNull(domicilio.getAltura());
        Assertions.assertEquals(1234, domicilio.getAltura());
    }

    @Test
    void getCiudad() {
        Domicilio domicilio= new Domicilio();

        domicilio.setCiudad("caba");
        Assertions.assertNotNull(domicilio.getCiudad());
        Assertions.assertEquals("caba", domicilio.getCiudad());
    }

    @Test
    void getPais() {
        Domicilio domicilio= new Domicilio();

        domicilio.setPais("Argentina");
        Assertions.assertNotNull(domicilio.getPais());
        Assertions.assertEquals("Argentina", domicilio.getPais());
    }

    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio(1L, "Pacheco", 124, "caba", "Argentina");

        Assertions.assertNotNull(domicilio.toString());
        Assertions.assertNotNull(domicilio);
    }
}