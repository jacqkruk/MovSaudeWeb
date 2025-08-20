package com.estudos.movSaudeWeb.pacientes;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO map(PacienteModel model);
    PacienteModel map(PacienteDTO dto);

}
