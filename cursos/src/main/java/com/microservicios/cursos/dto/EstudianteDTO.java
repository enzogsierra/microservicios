package com.microservicios.cursos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class EstudianteDTO 
{
    private String nombre;

    private String apellido;

    private String email;

    private Long cursoId;
}
