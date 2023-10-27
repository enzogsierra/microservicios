package com.microservicios.cursos.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservicios.cursos.dto.EstudianteDTO;


@FeignClient(name = "mcsv-estudiantes", url = "localhost:8090/api/v1/estudiantes")
public interface EstudianteClient 
{
    @GetMapping("/findByCurso/{cursoId}")
    List<EstudianteDTO> findByCursoId(@PathVariable Long cursoId);    
}
