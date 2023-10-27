package com.microservicios.cursos.http.response;

import java.util.List;

import com.microservicios.cursos.dto.EstudianteDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class EstudianteByCursoResponse 
{
    private String nombre;
    private String profesor;
    private List<EstudianteDTO> estudiantes;
}
