package com.microservicios.cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicios.cursos.client.EstudianteClient;
import com.microservicios.cursos.dto.EstudianteDTO;
import com.microservicios.cursos.http.response.EstudianteByCursoResponse;
import com.microservicios.cursos.model.Curso;
import com.microservicios.cursos.repository.CursoRepository;


@Service
public class CursoService implements iCursoService 
{
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteClient estudianteClient;


    @Override
    public List<Curso> findAll() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public EstudianteByCursoResponse findEstudiantesByCursoId(Long cursoId)
    {
        // Consultar el curso
        Curso curso = cursoRepository.findById(cursoId).orElse(null);

        // Obtener estudiantes del curso
        List<EstudianteDTO> estudiantes = estudianteClient.findByCursoId(cursoId);

        return EstudianteByCursoResponse.builder()
                    .nombre(curso.getNombre())
                    .profesor(curso.getProfesor())
                    .estudiantes(estudiantes)
                    .build();
    }
}
