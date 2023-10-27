package com.microservicios.estudiantes.service;

import java.util.List;

import com.microservicios.estudiantes.model.Estudiante;

public interface iEstudianteService 
{
    List<Estudiante> findAll();
    Estudiante findById(Long id);
    List<Estudiante> findByCursoId(Long cursoId);

    void save(Estudiante estudiante);
}
