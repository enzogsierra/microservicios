package com.microservicios.estudiantes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.estudiantes.model.Estudiante;
import com.microservicios.estudiantes.repository.EstudianteRepository;


@Service
public class EstudianteService implements iEstudianteService 
{
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> findAll() {
        return (List<Estudiante>) estudianteRepository.findAll();
    }

    @Override
    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Estudiante> findByCursoId(Long cursoId) {
        return (List<Estudiante>) estudianteRepository.findByCursoId(cursoId);
    }

    @Override
    public void save(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }
}
