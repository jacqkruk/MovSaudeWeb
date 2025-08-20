package com.estudos.movSaudeWeb.psicologos;

import com.estudos.movSaudeWeb.pacientes.PacienteDTO;
import com.estudos.movSaudeWeb.pacientes.PacienteModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface PsicologoMapper {
    PsicologoDTO map(PsicologoModel model);
    PsicologoModel map(PsicologoDTO dto);
}
