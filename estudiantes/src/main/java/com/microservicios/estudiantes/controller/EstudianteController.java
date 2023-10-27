package com.microservicios.estudiantes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.estudiantes.model.Estudiante;
import com.microservicios.estudiantes.service.EstudianteService;


@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteController 
{
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudiante> findAll()
    {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        Estudiante estudiante = estudianteService.findById(id);
        if(estudiante != null) return ResponseEntity.ok(estudiante);
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Estudiante estudiante)
    {
        estudianteService.save(estudiante);
    }


    @GetMapping("/findByCurso/{cursoId}")
    public ResponseEntity<?> findByCursoId(@PathVariable Long cursoId) 
    {
        List<Estudiante> estudiantes = estudianteService.findByCursoId(cursoId);
        return ResponseEntity.ok(estudiantes);
    }
}
