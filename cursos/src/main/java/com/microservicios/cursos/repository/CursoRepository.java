package com.microservicios.cursos.repository;

import org.springframework.data.repository.CrudRepository;

import com.microservicios.cursos.model.Curso;


public interface CursoRepository extends CrudRepository<Curso, Long> 
{
    
}
