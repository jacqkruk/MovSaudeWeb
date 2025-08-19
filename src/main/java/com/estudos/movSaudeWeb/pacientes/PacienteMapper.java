package com.estudos.movSaudeWeb.pacientes;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    PacienteDTO toDTO(PacienteModel model);
    PacienteModel toModel(PacienteDTO dto);

}
