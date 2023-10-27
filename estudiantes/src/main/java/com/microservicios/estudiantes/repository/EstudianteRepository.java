package com.microservicios.estudiantes.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.estudiantes.model.Estudiante;
import java.util.List;


public interface EstudianteRepository extends CrudRepository<Estudiante, Long> 
{
    List<Estudiante> findByCursoId(Long cursoId);
}
