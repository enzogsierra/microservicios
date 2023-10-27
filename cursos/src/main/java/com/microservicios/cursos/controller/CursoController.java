package com.microservicios.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.cursos.model.Curso;
import com.microservicios.cursos.service.CursoService;


@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController 
{
    @Autowired
    private CursoService cursoService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        Curso curso = cursoService.findById(id);
        if(curso != null) return ResponseEntity.ok(curso);
        else return ResponseEntity.badRequest().build();
    }

    @GetMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Curso curso) {
        cursoService.save(curso);
    }

    @GetMapping("/{id}/estudiantes")
    public ResponseEntity<?> findEstudiantesByCursoId(@PathVariable Long id)
    {
        return ResponseEntity.ok(cursoService.findEstudiantesByCursoId(id));
    }
}
