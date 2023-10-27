package com.microservicios.cursos.service;

import java.util.List;

import com.microservicios.cursos.http.response.EstudianteByCursoResponse;
import com.microservicios.cursos.model.Curso;

public interface iCursoService 
{
    List<Curso> findAll();
    Curso findById(Long id);
    
    void save(Curso curso);

    EstudianteByCursoResponse findEstudiantesByCursoId(Long cursoId);
}
