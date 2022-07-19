package com.exampleMySql.Prueba.repository;

import com.exampleMySql.Prueba.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

//Capa de acceso a datos
@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("SELECT o FROM Odontologo o where o.nombre = ?1")
    Optional<Odontologo> buscarOdontologoNombre(String nombre);


}
